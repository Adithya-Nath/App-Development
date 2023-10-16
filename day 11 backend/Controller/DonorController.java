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
import com.blooddonation.main.model.Donor;
import com.blooddonation.main.service.DonorService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

	@RestController
	@RequestMapping(Api.DONOR)
	@RequiredArgsConstructor
	@CrossOrigin("http://localhost:3000")
	@Tag(name = "blooddonation")
	public class DonorController {
			@Autowired
			DonorService donorService;
			

			@PostMapping("/post")
			public ResponseEntity<Donor> create(final @RequestBody Donor donors){
				Donor createUser=donorService.create(donors);
				return ResponseEntity.ok(createUser);
			}
			
			@GetMapping("/all")
		    public ResponseEntity<List<Donor>> getAllUsers() {
		        List<Donor> createcandidate = donorService.getAllDonorData();
		        return ResponseEntity.ok(createcandidate);
		    }
			
			@PutMapping("/put")
			public ResponseEntity<Donor> update(final @RequestBody Donor user)throws  JsonProcessingException{
				final Donor updatedUser=donorService.update(user);
				return ResponseEntity.ok(updatedUser);
			}
			
			@DeleteMapping("/delete/{id}")
			public void delete(final @PathVariable Long id) {
				donorService.delete(id);
			}
	}

