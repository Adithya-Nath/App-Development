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
import com.blooddonation.main.model.CampRegistration;
import com.blooddonation.main.service.CampRegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

	@RestController
	@RequestMapping(Api.CAMP)
	@RequiredArgsConstructor
	@CrossOrigin
	@Tag(name = "blooddonation")
	public class CampController {
			@Autowired
			CampRegistrationService CampRegistrationService;
			

			@PostMapping("/post")
			public ResponseEntity<CampRegistration> create(final @RequestBody CampRegistration CampRegistrations){
				CampRegistration createUser=CampRegistrationService.create(CampRegistrations);
				return ResponseEntity.ok(createUser);
			}
			
			@GetMapping("/all")
		    public ResponseEntity<List<CampRegistration>> getAllUsers() {
		        List<CampRegistration> createcandidate = CampRegistrationService.getAllCampRegistrationData();
		        return ResponseEntity.ok(createcandidate);
		    }
			
			@PutMapping("/put")
			public ResponseEntity<CampRegistration> update(final @RequestBody CampRegistration user)throws  JsonProcessingException{
				final CampRegistration updatedUser=CampRegistrationService.update(user);
				return ResponseEntity.ok(updatedUser);
			}
			
			@DeleteMapping("/delete/{id}")
			public void delete(final @PathVariable Long id) {
				CampRegistrationService.delete(id);
			}
	}
