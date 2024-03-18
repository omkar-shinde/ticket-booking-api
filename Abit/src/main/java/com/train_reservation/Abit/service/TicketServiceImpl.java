package com.train_reservation.Abit.service;

import com.train_reservation.Abit.entity.Seat;
import com.train_reservation.Abit.entity.Ticket;
import com.train_reservation.Abit.entity.User;
import com.train_reservation.Abit.Dto.TicketDTO;
import com.train_reservation.Abit.exception.TicketNotFoundException;
import com.train_reservation.Abit.repository.SeatRepository;
import com.train_reservation.Abit.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
  
    @Autowired
    private SeatRepository seatRepository; 

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, SeatRepository seatRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
    }
    
    @Override
    public List<TicketDTO> getTicketsBySection(String sectionName) {
        List<Ticket> tickets = ticketRepository.findBySeat_SectionName(sectionName);
        return tickets.stream()
                .map(this::convertToDTO1)
                .collect(Collectors.toList());
    }

    private TicketDTO convertToDTO1(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setPrice(ticket.getPrice());
        dto.setFrom(ticket.getFrom());
        dto.setTo(ticket.getTo());
        dto.setArrival(ticket.getArrival());
        dto.setDeparture(ticket.getDeparture());
        dto.setPickupPoint(ticket.getPickupPoint());
        return dto;
    }
   
    @Override
    public Ticket purchaseTicket(String from, String to, String firstName, String lastName, String email, double price, int seatNumber, String sectionname) {
        
        Ticket ticket = new Ticket();
        ticket.setFrom(from);
        ticket.setTo(to);
        ticket.setPrice(price);
        ticket.setArrival(Instant.now()); 
        ticket.setDeparture(Instant.now().plusSeconds(3600)); 
        ticket.setPickupPoint("Some pickup point"); 

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        ticket.setUser(user);

       
        Seat seat = seatRepository.findBySeatNumberAndSectionName(seatNumber, sectionname);
        if (seat != null && !seat.isReserved()) {
            
            ticket.setSeat(seat);
            seat.setReserved(true); 
            seatRepository.save(seat);
           
            return ticketRepository.save(ticket);
        } else {
            
            return null;
        }
    }
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    @Transactional
    public ResponseEntity<String> modifyUserSeat(Long userId, int newSeatNumber) {
       
        Ticket ticket = ticketRepository.findTicketByUserId(userId);
        if (ticket == null) {
            return new ResponseEntity<>("Ticket not found for user ID: " + userId, HttpStatus.NOT_FOUND);
        }

        Seat newSeat = seatRepository.findBySeatNumberAndReserved(newSeatNumber, false);
        if (newSeat == null) {
            return new ResponseEntity<>("Seat " + newSeatNumber + " is not available or already reserved", HttpStatus.BAD_REQUEST);
        }

        Seat previousSeat = ticket.getSeat();
        if (previousSeat != null) {
            previousSeat.setReserved(false);
        }

        newSeat.setReserved(true);
        ticket.setSeat(newSeat);
        ticketRepository.save(ticket);
        
        return new ResponseEntity<>("User's seat modified successfully", HttpStatus.OK);
    }
    
    
    @Override
    @Transactional
    public void removeUserFromTrain(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));

        Seat seat = ticket.getSeat();
        if (seat != null) {
            seat.setReserved(false);
            seatRepository.save(seat);
        }

        ticket.setUser(null);
        ticketRepository.save(ticket);
    }
 

    
    private TicketDTO convertToDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setFrom(ticket.getFrom());
        ticketDTO.setTo(ticket.getTo());
        ticketDTO.setArrival(ticket.getArrival());
        ticketDTO.setDeparture(ticket.getDeparture());
        ticketDTO.setPickupPoint(ticket.getPickupPoint());
        return ticketDTO;
    }
    
    @Override
    public TicketDTO getTicketById(Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            return convertToDTO(ticket);
        } else {
            throw new TicketNotFoundException("Ticket not found with ID: " + ticketId);
        }
    }
}