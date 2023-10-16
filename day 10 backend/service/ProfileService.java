package com.blooddonation.main.service;

import java.util.List;
import java.util.Optional;

//ProfileDetailsService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blooddonation.main.model.Profile;
import com.blooddonation.main.repository.ProfileRepo;

@Service
public class ProfileService {
	@Autowired
 private ProfileRepo pr;

 
 

 public Profile saveProfileDetails(Profile profileDetails) {
     return pr.save(profileDetails);
 }

 public List<Profile> getAllProfileDetails() {
     return pr.findAll();
 }

 public Optional<Profile> getProfileDetailsById(Long id) {
     return pr.findById(id);
 }

 public void deleteProfileDetails(Long id) {
     pr.deleteById(id);
 }
}
