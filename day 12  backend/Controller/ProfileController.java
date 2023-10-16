package com.blooddonation.main.Controller;


import java.util.List;
import java.util.Optional;

//ProfileDetailsController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blooddonation.main.constant.Api;
import com.blooddonation.main.model.Profile;
import com.blooddonation.main.service.ProfileService;

import lombok.RequiredArgsConstructor;
@CrossOrigin
@RestController
@RequestMapping(Api.PROFILE)
@RequiredArgsConstructor
public class ProfileController {
 private final ProfileService pr;


 @PostMapping("/save")
 public Profile saveProfileDetails(@RequestBody Profile profileDetails) {
     return pr.saveProfileDetails(profileDetails);
 }

 @GetMapping("/all")
 public List<Profile> getAllProfileDetails() {
     return pr.getAllProfileDetails();
 }

 @GetMapping("/{id}")
 public Optional<Profile> getProfileDetailsById(@PathVariable Long id) {
     return pr.getProfileDetailsById(id);
 }

 @DeleteMapping("/{id}")
 public void deleteProfileDetails(@PathVariable Long id) {
     pr.deleteProfileDetails(id);
 }
}
