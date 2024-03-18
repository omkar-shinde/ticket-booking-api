package com.train_reservation.Abit.repository;
import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.train_reservation.Abit.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	void deleteById(User user);

	void deleteByUser(com.train_reservation.Abit.entity.User user);

	Optional<Ticket> findByUser(User user);
	
	Optional<Ticket> findByUserId(Long userId);

	void deleteByUserId(Long userId);

	Ticket findTicketByUserId(Long userId);

	java.util.List<Ticket> findBySeat_SectionName(String sectionName);

	 
	
	
}
