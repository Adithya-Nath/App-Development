package com.blooddonation.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonation.main.model.Donor;

public interface DonorRepo extends JpaRepository<Donor, Long> {

}
