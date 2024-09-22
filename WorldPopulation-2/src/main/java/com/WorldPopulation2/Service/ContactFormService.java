package com.WorldPopulation2.Service;

import org.springframework.stereotype.Service;
import com.WorldPopulation2.Entity.ContactForm;

@Service
public interface ContactFormService {

	ContactForm save(ContactForm contact);

	void SaveMessage(String email, String name, String message);
}
