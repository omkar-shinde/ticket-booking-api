package com.train_reservation.Abit.Dto;

import org.apache.catalina.User;
import com.train_reservation.Abit.entity.Seat;

public class UserDTO {
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	    

}