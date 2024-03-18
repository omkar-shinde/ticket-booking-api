package com.train_reservation.Abit.repository;
import com.train_reservation.Abit.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);




}