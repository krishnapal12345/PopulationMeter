package com.WorldPopulation2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Entity.State;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

	List<Country> findByCountryName(String countryName);
	

	void save(String name);
}

