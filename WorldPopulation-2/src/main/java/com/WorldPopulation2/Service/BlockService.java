package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.State;

@Service
public interface BlockService {

	BlockPopulationDetails saveBlockData(BlockPopulationDetails details,String countryName,String stateName);

	List<BlockPopulationDetails> getAllData(String countryName,String stateName,int blockNumber);
	
	
}
