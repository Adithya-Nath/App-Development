package com.blooddonation.main.model;

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
@Table(name="profile")
public class Profile {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 private String fullName;
 private String email;
 private String phoneNumber;
 private String address;


 // Constructors, getters, and setters
}
