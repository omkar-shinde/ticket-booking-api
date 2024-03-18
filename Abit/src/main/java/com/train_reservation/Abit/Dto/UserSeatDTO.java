package com.train_reservation.Abit.Dto;

import org.apache.catalina.User;
import com.train_reservation.Abit.entity.Seat;

public class UserSeatDTO {
    private UserDTO user;
    private String sectionname;
    private int seatNumber;
    
    
	public String getSection() {
		return sectionname;
	}
	public void setSection(String sectionname) {
		this.sectionname = sectionname;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
  
	   public UserSeatDTO(UserDTO user, int seatNumber) {
	        this.user = user;
	        this.seatNumber = seatNumber;
	    }

}
