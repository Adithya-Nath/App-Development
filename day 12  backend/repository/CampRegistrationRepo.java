package com.blooddonation.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonation.main.model.CampRegistration;

public interface CampRegistrationRepo extends JpaRepository<CampRegistration, Long> {

}