package com.example.blooddonationapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BloodDonationRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requesterName;
    private String bloodGroup;
    private String location;
    private boolean isUrgent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequesterName() {
		return requesterName;
	}
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public BloodDonationRequestModel(Long id, String requesterName, String bloodGroup, String location, boolean isUrgent) {
		super();
		this.id = id;
		this.requesterName = requesterName;
		this.bloodGroup = bloodGroup;
		this.location = location;
		this.isUrgent = isUrgent;
	}
	public BloodDonationRequestModel() {
		super();
	}

    
}
