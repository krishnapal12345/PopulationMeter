package com.WorldPopulation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
