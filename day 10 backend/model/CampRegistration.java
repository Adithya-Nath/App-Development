package com.blooddonation.main.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="camp")
public class CampRegistration {
	@Id
	
	private String organizerName;
	private String organizerEmail;
	private String coOrganizerName;
	private String coOrganizerEmail;
	private String campName;
	private String cityName;
	private String estimatedParticipants;
	private String campProposeDate;
	private String remarks;
	private String organizationName;
	private String organizerMobileNo;
	private String coOrganizerMobile;
	private String campAddress;
	private String district;
	private String bloodBank;
	private String latitude;
	private String longitude;

}