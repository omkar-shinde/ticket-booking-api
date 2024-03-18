package com.train_reservation.Abit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.train_reservation.Abit.entity.Seat;


public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByReserved(boolean reserved);
    
    List<Seat> findBySeatNumber(int seatNumber);
    
    Seat findBySeatNumberAndReserved(int seatNumber, boolean reserved);
    
	Seat findFirstByReservedFalse();
	
	Seat findBySeatNumberAndSectionName(int seatNumber, String section);
 
}