package com.train_reservation.Abit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.train_reservation.Abit.Dto.*;
import com.train_reservation.Abit.entity.Ticket;
import com.train_reservation.Abit.service.TicketService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/tickets")
@Api(tags = "Ticket Management")
public class TicketController {
	
	@GetMapping(value = "/product")
	public String getProduct() {
	 return "manr";
    }
	
	@Autowired
    private TicketService ticketService;
	
	
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    
    //An API to view the users and seat they are allocated by the requested section//
    @GetMapping("/section/{sectionName}")
    public ResponseEntity<List<TicketDTO>> getTicketsBySection(@PathVariable String sectionName) {
        List<TicketDTO> tickets = ticketService.getTicketsBySection(sectionName);
        return ResponseEntity.ok(tickets);
    }
    
       
    
    //API for submit a purchase for a ticket.//
    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam double price,
            @RequestParam int seatNumber,
            @RequestParam String sectionname) {

        Ticket purchasedTicket = ticketService.purchaseTicket(from, to, firstName, lastName, email, price, seatNumber, sectionname);

        if (purchasedTicket != null) {
            return ResponseEntity.ok(purchasedTicket);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
       
    
    //An API to modify a user's seat//
    @PutMapping("/modify")
    public ResponseEntity<String> modifyUserSeat(@RequestParam Long userId, @RequestParam int newSeatNumber) {
        ResponseEntity<String> response = ticketService.modifyUserSeat(userId, newSeatNumber);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
    
    
    // An API that shows the details of the receipt for the user//
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDTO> getTicketReceipt(@PathVariable Long ticketId) {
        TicketDTO ticketDTO = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticketDTO);
    }
    

    // An API to remove a user from the train//
    @DeleteMapping("/delete/{ticketId}")
    public ResponseEntity<String> removeUserFromTrain(@PathVariable Long ticketId) {
        ticketService.removeUserFromTrain(ticketId);
        return new ResponseEntity<>("User removed from the train successfully", HttpStatus.OK);
    }
    


}
