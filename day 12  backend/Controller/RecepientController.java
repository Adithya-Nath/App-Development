package com.blooddonation.main.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blooddonation.main.constant.Api;
import com.blooddonation.main.model.Recepient;
import com.blooddonation.main.service.RecepientService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

	@RestController
	@RequestMapping(Api.RECEPIENT)
	@RequiredArgsConstructor
	@CrossOrigin("http://localhost:3000")
	@Tag(name = "blooddonation")
	public class RecepientController {
			@Autowired
			RecepientService RecepientService;
			

			@PostMapping("/post")
			public ResponseEntity<Recepient> create(final @RequestBody Recepient Recepients){
				Recepient createUser=RecepientService.create(Recepients);
				return ResponseEntity.ok(createUser);
			}
			
			@GetMapping("/all")
		    public ResponseEntity<List<Recepient>> getAllUsers() {
		        List<Recepient> createcandidate = RecepientService.getAllRecepientData();
		        return ResponseEntity.ok(createcandidate);
		    }
			
			@PutMapping("/put")
			public ResponseEntity<Recepient> update(final @RequestBody Recepient user)throws  JsonProcessingException{
				final Recepient updatedUser=RecepientService.update(user);
				return ResponseEntity.ok(updatedUser);
			}
			
			@DeleteMapping("/delete/{id}")
			public void delete(final @PathVariable Long id) {
				RecepientService.delete(id);
			}
	}