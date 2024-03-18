package com.train_reservation.Abit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.train_reservation.Abit.service"})
@ComponentScan(basePackages ={"com.train_reservation.Abit.controllers"})
@EntityScan(basePackages = {"com.train_reservation.Abit.entity"})
public class AbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbitApplication.class, args);
	}

}
