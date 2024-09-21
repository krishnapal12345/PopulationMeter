package com.WorldPopulation2.Service;

import org.springframework.stereotype.Service;
import com.WorldPopulation2.Entity.Contact;

@Service
public interface ContactService {

	Contact save(Contact contact);

	void SaveMessage(String email, String name, String message);
}
