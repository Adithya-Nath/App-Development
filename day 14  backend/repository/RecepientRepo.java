package com.blooddonation.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonation.main.model.Recepient;

public interface RecepientRepo extends JpaRepository<Recepient, Long> {

}