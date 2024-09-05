package com.WorldPopulation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

	Country findByName(String name);
}

