package com.train_reservation.Abit.Dto;
import java.time.Instant;

import com.train_reservation.Abit.entity.Seat;


public class TicketDTO {
    private double Price;
    private String From;
    private Long id;
    private String To;
    private Instant Arrival;
    private Instant Departure;
    private String Pickup_point;
    private Seat seat;
    
    
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String From) {
		this.From = From;
	}
	
	public String getTo() {
		return To;
	}
	public void setTo(String To) {
		this.To = To;
	}
	public Instant getArrival() {
		return Arrival;
	}
	public void setArrival(Instant Arrival) {
		this.Arrival = Arrival;
	}
	public Instant getDeparture() {
		return Departure;
	}
	public void setDeparture(Instant Departure) {
		this.Departure = Departure;
	}
	public String getPickupPoint() {
		return Pickup_point;
	}
	public void setPickupPoint(String Pickup_point) {
		this.Pickup_point = Pickup_point;
	}
	
	public Long getId() {
		return id;
	}
	
	public Seat getSeatId() {
		return seat;
	}
	public void setSeatId(Seat seat) {
		this.seat = seat;
	}
	
	public void setId(Long id) {
		this.id = id;
		
	}
	public Long getSeatNumber() {
		 return seat != null ? (long) seat.getSeatNumber() : null;
	}
	
}
