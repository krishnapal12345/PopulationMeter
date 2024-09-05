package com.WorldPopulation2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public String getstatecodeByName(String statename) {
		
		State state=stateRepository.findBystatename(statename);
		if(state != null) {
			return state.getStatecode();
		}
		return null;
	}
}
