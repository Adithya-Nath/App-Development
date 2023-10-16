package com.blooddonation.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blooddonation.main.dto.response.UserResponse;
import com.blooddonation.main.model.Role;
import com.blooddonation.main.model.User;
import com.blooddonation.main.repository.UserRepo;


@Service

public class UserService {
      
      @Autowired
  	UserRepo userRepository;
  	public User create(User users) {
  		return userRepository.save(users);
  	}
  	public Optional<User> read(Long id){
  		return userRepository.findById(id);
  	}
  	public User update(User users) {
  		return userRepository.save(users);
  		
  	}
  	
  	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
  	
  	public void delete(Long Id) {
  		userRepository.deleteById(Id);
  	}
  	
  	private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .uid(user.getUid())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}