package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="states")
public class State {
	
	@Id
	private int id;
	private String statename;
	private String statecode;
	private String country_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public State(int id, String state_name, String state_code, String country_code) {
		super();
		this.id = id;
		this.statename = statename;
		this.statecode = statecode;
		this.country_code = country_code;
	}
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

