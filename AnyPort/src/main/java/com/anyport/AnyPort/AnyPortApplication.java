package com.anyport.AnyPort;

import com.anyport.AnyPort.models.Address;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AnyPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnyPortApplication.class, args);
	}

	@Bean
	public User createUser(){
		return new User();
	}

	@Bean
	public Orders createOrdersObject(){
		return new Orders();
	}

	@Bean
	public Address createAddress(){
		return new Address();
	}


}
