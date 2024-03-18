package com.train_reservation.Abit.Dto;

import lombok.Data;

@Data
public class ModifySeatRequestDTO {
    private String sectionname;
    private int newSeatNumber;
    // Additional fields as needed
	public String getSection() {
		return sectionname;
	}
	public void setSection(String sectionname) {
		this.sectionname = sectionname;
	}
	public int getNewSeatNumber() {
		return newSeatNumber;
	}
	public void setNewSeatNumber(int newSeatNumber) {
		this.newSeatNumber = newSeatNumber;
	}
}