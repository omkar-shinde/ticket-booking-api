package com.train_reservation.Abit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "reserved")
    private boolean reserved;

    public Seat() {
    }

    public Seat(String screenName, String sectionname, int seatNumber, boolean reserved) {
        this.sectionName = sectionname;
        this.seatNumber = seatNumber;
        this.reserved = reserved;
   
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionname) {
        this.sectionName = sectionname;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

}
