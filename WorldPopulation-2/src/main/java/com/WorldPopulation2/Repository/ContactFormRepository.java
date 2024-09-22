package com.WorldPopulation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.ContactForm;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm,Integer>{

}
