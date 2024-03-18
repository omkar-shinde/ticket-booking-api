package com.train_reservation.Abit.service;

import org.springframework.http.ResponseEntity;
import com.train_reservation.Abit.entity.Ticket;
import com.train_reservation.Abit.Dto.TicketDTO;


public interface TicketService {
	
    void removeUserFromTrain(Long userId);

	TicketDTO getTicketById(Long ticketId);
	
	ResponseEntity<String> modifyUserSeat(Long userId, int newSeatNumber);
	
	Ticket purchaseTicket(String from, String to, String firstName, String lastName, String email, double price, int seatNumber, String sectionname);

	java.util.List<TicketDTO> getTicketsBySection(String sectionName);
	

}