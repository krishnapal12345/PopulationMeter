package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="messages")
@Data
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String message;
	
	public Contact(String name,String email,String message) {
		this.name=name;
		this.email=email;
		this.message=message;
	}
	
}
