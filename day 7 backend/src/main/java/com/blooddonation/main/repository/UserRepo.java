package com.blooddonation.main.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blooddonation.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	Optional<User> findByEmail(String username);
	User findByUid(Long id);

    void deleteByUid(Long Uid);
}