package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="states")
@Data
public class State {
	
	@Id
	private int id;
	private String statename;
	private String statecode;
	private String country_code;

}

