package com.WorldPopulation2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.ContactDto;
import com.WorldPopulation2.Entity.Contact;
import com.WorldPopulation2.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Contact save(ContactDto contactdto) {
	 
		Contact contact=new Contact(contactdto.getName(),contactdto.getEmail(),contactdto.getMessage());
		
		return contactRepository.save(contact);
	}
	
	@Override
	public void SubmitMessage(String email,String name,String message) {
		ContactDto contactdto=new ContactDto();
		contactdto.setEmail(email);
		contactdto.setName(name);
		contactdto.setMessage(message);
		
		save(contactdto);
	}
}
