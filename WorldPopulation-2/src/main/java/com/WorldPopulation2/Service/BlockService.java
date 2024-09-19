package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.BlockDto;
import com.WorldPopulation2.Entity.BlockPopulationDetails;

@Service
public interface BlockService {

	BlockPopulationDetails save(BlockDto blockdto);

	List<BlockPopulationDetails> getBlockPopulationDetailsDetails(String countrycode, String statecode, int blockNumber);
 
	List<BlockDto> getAllData(String countrycode,String statecode,int blockNumber);
	
	void SubmitData(String country,String state,int blockNumber,int totalPopulation,int malePopulation,int femalePopulation,int totalEducated,int femaleEducated,int maleEducated,int avgAge);
}
