package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.EduGraphDto;
import com.WorldPopulation2.Entity.BlockPopulationDetails;

@Service
public class EducationalStat {

	private static  Logger logger=LoggerFactory.getLogger(EducationalStat.class);
	
	@Autowired
	private BlockService blockService;
	
	public List<EduGraphDto> getEduData(String country,String state,int blockNumber){
		logger.info("Fetching education graph for country: {}, state: {}, block number: {}", country, state, blockNumber);
		return blockService.getAllData(country, state, blockNumber).stream()
	            .map(block -> new EduGraphDto(block.getMaleEducated(), block.getFemaleEducated()))
	            .collect(Collectors.toList());
	}
}
