package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.BlockRepository;
import com.WorldPopulation2.Repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired 
	private BlockRepository blockRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Override
    public BlockPopulationDetails saveBlockData(BlockPopulationDetails details, String countryName, String stateName) {
        List<State> states = stateRepository.findByStateNameAndCountry_CountryName(stateName, countryName);
              if(states.isEmpty()) {  
        		throw new EntityNotFoundException("State not found: " + stateName + " in country: " + countryName);
              }
        State state=states.get(0);
        
        details.setState(state);
        return blockRepository.save(details);
    }
	
	public List<BlockPopulationDetails> getAllData(String countryName,String stateName,int blockNumber){
		return blockRepository.findByCountryStateAndBlockNumber(countryName, stateName, blockNumber);
    }
}

	


	


