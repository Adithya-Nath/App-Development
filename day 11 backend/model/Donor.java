
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
@Table(name="donor")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long did;
	private String name;
	private String bloodtype;
	private int age;
	private float weight;
    private float heamoglobinlevel;
    private float pulse;
    private float bloodpressure;
  
    
}