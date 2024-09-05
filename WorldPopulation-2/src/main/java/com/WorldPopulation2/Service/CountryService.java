package com.WorldPopulation2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public String getcodeByName(String name) {
		Country country=countryRepository.findByName(name);
		if(country != null) {
			return country.getCode();
		}
		return null;
	}
}
