package com.WorldPopulation2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.WorldPopulation2.Entity.Contact;
import com.WorldPopulation2.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Contact save(Contact contact) {
		
		return contactRepository.save(contact);
	}
	
	 @Override
	    public void SaveMessage(String email, String name, String message) {
	        Contact contact = new Contact(name, email, message);
	        save(contact);
	        
	    }
}