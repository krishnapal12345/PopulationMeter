package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.CountryRepository;
import com.WorldPopulation2.Repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public State saveStateData(String stateName, String countryName) {
		
		List<Country> countries = countryRepository.findByCountryName(countryName);//to handle duplicate entries
        if (countries.isEmpty()) {
            throw new EntityNotFoundException("Country not found: " + countryName);
        }
        Country country = countries.get(0);// to get first country if more then one country found
        
        List<State> states = stateRepository.findByStateNameAndCountry(stateName, country);
        if (states.isEmpty()) {
            return stateRepository.save(new State(stateName, country));
        } else {
            
            return states.get(0);//to get first state if more than one state found
        }
    }
}
