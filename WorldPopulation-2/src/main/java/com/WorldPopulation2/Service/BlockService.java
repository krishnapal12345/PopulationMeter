package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.BlockPopulationDetails;

@Service
public interface BlockService {

	BlockPopulationDetails save(BlockPopulationDetails blockPopulationDetails);

	List<BlockPopulationDetails> getAllData(String countrycode,String statecode,int blockNumber);
	
	 void SaveData(String country,String state,int blockNumber,int totalPopulation,int malePopulation,int femalePopulation,int totalEducated,int femaleEducated,int maleEducated,int avgAge);
}
