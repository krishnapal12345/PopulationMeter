package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.GraphGenderDto;

@Service
public class GenderRatioStat {

	private static  Logger logger=LoggerFactory.getLogger(GenderRatioStat.class);
	
	@Autowired
	private BlockService blockService;
	
	public List<GraphGenderDto> getGenderData(String country,String state,int blockNumber){
		logger.info("Fetching GenderRatio graph for country: {}, state: {}, block number: {}", country, state, blockNumber);
		return blockService.getAllData(country, state, blockNumber)
				.stream()
				.map(block -> new GraphGenderDto(block.getMalePopulation(),block.getFemalePopulation()))
				.collect(Collectors.toList());
	}
	
	
}
