package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="message")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String messsage;
	
	public Contact() {
		
	}
	
	public Contact(String name,String email,String message) {
		this.name=name;
		this.email=email;
		this.messsage=message;
		
	}
	
}
