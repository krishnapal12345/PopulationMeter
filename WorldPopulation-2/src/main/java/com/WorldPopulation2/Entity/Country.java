package com.WorldPopulation2.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="country" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<State> states;
//	
}
