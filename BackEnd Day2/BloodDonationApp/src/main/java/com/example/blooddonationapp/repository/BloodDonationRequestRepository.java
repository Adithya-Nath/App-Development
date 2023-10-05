package com.example.blooddonationapp.repository;

import com.example.blooddonationapp.model.BloodDonationRequestModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonationRequestRepository extends JpaRepository<BloodDonationRequestModel, Long> {
	List<BloodDonationRequestModel> findByRequesterName(String requesterName);
    List<BloodDonationRequestModel> findByBloodGroup(String bloodGroup);
    List<BloodDonationRequestModel> findByLocation(String location);
    List<BloodDonationRequestModel> findByIsUrgent(boolean isUrgent);
}