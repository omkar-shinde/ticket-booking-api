package com.train_reservation.Abit.entity;

import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "price")
    private double price;
   
    @Column(name = "\"from\"")
    private String From;
    
    @Column(name = "\"to\"")
    private String To;
      
    @Column(name = "arrival")
    private Instant Arrival;
      
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat; 
    
    @Column(name = "departure")
    private Instant Departure;
    
    @Column(name = "pickup_point")
    private String Pickup_point;
        
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setFrom(String From) {
		this.From = From;
	}
	
	public String getFrom() {
		return From;
	}
	
	public void setTo(String To) {
		this.To = To;
	}
	
	public String getTo() {
		return To;
	}
	
	public void setArrival(Instant Arrival) {
		this.Arrival = Arrival;
	}
	
	public Instant getArrival() {
		return Arrival;
	}
	
	public void setDeparture(Instant Departure) {
		this.Departure = Departure;
	}
	
	public Instant getDeparture() {
		return Departure;
	}
	
	public String getPickupPoint() {
		return Pickup_point;
	}
	public void setPickupPoint(String Pickup_point) {
		this.Pickup_point = Pickup_point;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public Seat getSeatNumber() {
        return null;
    }
	
	public void setSeatNumber(int newSeatNumber) {
        if (seat == null) {        
            seat = new Seat();
        }
        seat.setSeatNumber(newSeatNumber);
		
	}
	public void setSection(String section) {

	}
	
	public String getSection(String section) {
	     if (section != null) {
	            return seat.getSectionName();
	        }
	        return "";	
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public Seat getSeat() {
		return seat;
	}
	
	  public void setSeat(Seat newSeat) {
	       
		  if (newSeat != null && !newSeat.isReserved()) {
		        
		        if (this.seat == null || !this.seat.isReserved()) {
		            
		            if (seat != null) {
		                seat.setReserved(false); 
		            }
		            
		            this.seat = newSeat;
		            newSeat.setReserved(true); 
		        }
	    }}
}
