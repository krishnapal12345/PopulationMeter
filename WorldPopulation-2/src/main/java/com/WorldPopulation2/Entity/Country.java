package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="countries")
@Data
public class Country {

	@Id
	private int id;
	private String code;
	private String name;
//	
}
