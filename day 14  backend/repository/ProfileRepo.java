package com.blooddonation.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonation.main.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

}
