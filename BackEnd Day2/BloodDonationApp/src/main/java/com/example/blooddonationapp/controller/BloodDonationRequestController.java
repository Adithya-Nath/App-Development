package com.example.blooddonationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blooddonationapp.model.BloodDonationRequestModel;
import com.example.blooddonationapp.service.BloodDonationRequestService;

@RestController
@RequestMapping("/api/blood-donation-requests")
public class BloodDonationRequestController {

	@Autowired
    private final BloodDonationRequestService service;

    public BloodDonationRequestController(BloodDonationRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<BloodDonationRequestModel> getAllRequests() {
        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public BloodDonationRequestModel getRequestById(@PathVariable Long id) {
        return service.getRequestById(id);
    }

    @GetMapping("/requesterName/{requesterName}")
    public List<BloodDonationRequestModel> getRequestsByRequesterName(@PathVariable String requesterName) {
        return service.getRequestsByRequesterName(requesterName);
    }

    @GetMapping("/bloodGroup/{bloodGroup}")
    public List<BloodDonationRequestModel> getRequestsByBloodGroup(@PathVariable String bloodGroup) {
        return service.getRequestsByBloodGroup(bloodGroup);
    }

    @GetMapping("/location/{location}")
    public List<BloodDonationRequestModel> getRequestsByLocation(@PathVariable String location) {
        return service.getRequestsByLocation(location);
    }

    @GetMapping("/isUrgent/{isUrgent}")
    public List<BloodDonationRequestModel> getUrgentRequests(@PathVariable boolean isUrgent) {
        return service.getUrgentRequests(isUrgent);
    }

    @PostMapping("/post")
    public BloodDonationRequestModel createRequest(@RequestBody BloodDonationRequestModel request) {
        return service.createRequest(request);
    }

    @PutMapping("/{id}")
    public BloodDonationRequestModel updateRequest(@PathVariable Long id, @RequestBody BloodDonationRequestModel updatedRequest) {
        return service.updateRequest(id, updatedRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
    }
}