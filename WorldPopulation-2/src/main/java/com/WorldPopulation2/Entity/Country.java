package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="countries")
public class Country {

	@Id
	private int id;
	private String code;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
//	
}
