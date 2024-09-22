package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public Country saveCountryData(String countryName) {
        List<Country> countries = countryRepository.findByCountryName(countryName);
        if (countries.isEmpty()) {
            return countryRepository.save(new Country(countryName));
        } else {
            return countries.get(0);
        }
    }
}
