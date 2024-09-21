package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired 
	private BlockRepository blockRepository;
	
	@Override
	public  BlockPopulationDetails save(BlockPopulationDetails blockPopulationDetails) {
		
		 return blockRepository.save(blockPopulationDetails);
	}
	
	
	public void SaveData(String country, String state, int blockNumber, int totalPopulation,
               int malePopulation, int femalePopulation, int totalEducated, 
               int femaleEducated, int maleEducated, int avgAge) {
               BlockPopulationDetails details = new BlockPopulationDetails(blockNumber, state, country, totalPopulation, malePopulation, femalePopulation, totalEducated, maleEducated, femaleEducated, avgAge
                   );
             save(details);
               }
	


	public List<BlockPopulationDetails> getAllData(String countrycode,String statecode,int blockNumber){
		return blockRepository.findByCountrycodeAndStatecodeAndBlockNumber(countrycode, statecode,blockNumber);
	}

	

}
