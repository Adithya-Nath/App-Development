package com.example.blooddonationapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blooddonationapp.model.BloodDonationRequestModel;
import com.example.blooddonationapp.repository.BloodDonationRequestRepository;

@Service
public class BloodDonationRequestService {

    private final BloodDonationRequestRepository repository;

    @Autowired
    public BloodDonationRequestService(BloodDonationRequestRepository repository) {
        this.repository = repository;
    }

    public List<BloodDonationRequestModel> getAllRequests() {
        return repository.findAll();
    }

    public BloodDonationRequestModel getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<BloodDonationRequestModel> getRequestsByRequesterName(String requesterName) {
        return repository.findByRequesterName(requesterName);
    }

    public List<BloodDonationRequestModel> getRequestsByBloodGroup(String bloodGroup) {
        return repository.findByBloodGroup(bloodGroup);
    }

    public List<BloodDonationRequestModel> getRequestsByLocation(String location) {
        return repository.findByLocation(location);
    }

    public List<BloodDonationRequestModel> getUrgentRequests(boolean isUrgent) {
        return repository.findByIsUrgent(isUrgent);
    }

    public BloodDonationRequestModel createRequest(BloodDonationRequestModel request) {
        return repository.save(request);
    }

    public BloodDonationRequestModel updateRequest(Long id, BloodDonationRequestModel updatedRequest) {
        Optional<BloodDonationRequestModel> existingRequestOptional = repository.findById(id);

        if (existingRequestOptional.isPresent()) {
            BloodDonationRequestModel existingRequest = existingRequestOptional.get();
            existingRequest.setRequesterName(updatedRequest.getRequesterName());
            existingRequest.setBloodGroup(updatedRequest.getBloodGroup());
            existingRequest.setLocation(updatedRequest.getLocation());
            existingRequest.setUrgent(updatedRequest.isUrgent());

            return repository.save(existingRequest);
        }

        return null;
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
