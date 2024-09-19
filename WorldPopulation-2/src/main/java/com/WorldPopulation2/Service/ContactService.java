package com.WorldPopulation2.Service;

import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.ContactDto;
import com.WorldPopulation2.Entity.Contact;

@Service
public interface ContactService {

	Contact save(ContactDto contactdto);

	void SubmitMessage(String email, String name, String message);
}
