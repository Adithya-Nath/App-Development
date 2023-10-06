package com.blooddonation.main.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blooddonation.main.constant.Api;
import com.blooddonation.main.model.User;
import com.blooddonation.main.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(Api.USER)
public class UserController {
	
	UserService userService;
	
	@GetMapping("/")
	public String home()
	{
		return("<h1>Hello</h1>");
	}
	@GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

	@PostMapping("/post")
	public ResponseEntity<User> create(final @RequestBody User users){
		User createUser=userService.create(users);
		return ResponseEntity.ok(createUser);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<User>> read(final @PathVariable Long id){
		Optional<User> createdCandidate=userService.read(id);
		return ResponseEntity.ok(createdCandidate);
	}
	
	@PutMapping("/put/{uid}")
	public ResponseEntity<User> update(@PathVariable Long uid, @RequestBody User user) throws JsonProcessingException {
	    Optional<User> existingUserOptional = userService.read(uid);

	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();

	        
	        existingUser.setName(user.getName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setRole(user.getRole());
	        
	        
	        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
	            
	            existingUser.setPassword(user.getPassword());
	        }
	        
	        
	        final User updatedUser = userService.update(existingUser);
	        return ResponseEntity.ok(updatedUser);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/delete/{id}")
	public void delete(final @PathVariable Long id) {
		userService.delete(id);
	}
}
