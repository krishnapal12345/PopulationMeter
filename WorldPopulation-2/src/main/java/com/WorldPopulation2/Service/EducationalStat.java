package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.EduGraphDto;
import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.BlockRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EducationalStat {

	private static  Logger logger=LoggerFactory.getLogger(EducationalStat.class);
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private BlockRepository blockRepository;
	
	public List<BlockPopulationDetails> getBlockPopulationDetails(String countryName, String stateName, int blockNumber) {
        return blockRepository.findByCountryStateAndBlockNumber(countryName, stateName, blockNumber);
    }
	
	public List<EduGraphDto> getEduData(String countryName,String stateName,int blockNumber){
		logger.info("Fetching education graph for country: {}, state: {}, block number: {}", countryName, stateName, blockNumber);
		return blockService.getAllData(countryName,stateName, blockNumber)
				.stream()
	            .map(block -> new EduGraphDto(block.getMaleEducated(), block.getFemaleEducated()))
	            .collect(Collectors.toList());
	}
	
	
}
