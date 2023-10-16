package com.blooddonation.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
public class BlooddonationappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlooddonationappApplication.class, args);
	}

}
