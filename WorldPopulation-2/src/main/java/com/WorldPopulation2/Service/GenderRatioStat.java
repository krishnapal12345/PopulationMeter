package com.WorldPopulation2.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.GraphGenderDto;
import com.WorldPopulation2.Entity.State;

@Service
public class GenderRatioStat {

	private static  Logger logger=LoggerFactory.getLogger(GenderRatioStat.class);
	
	@Autowired
	private BlockService blockService;
	
	public List<GraphGenderDto> getGenderData(String countryName,String stateName,int blockNumber){
		return blockService.getAllData(countryName, stateName, blockNumber)
				.stream()
				.map(block ->new GraphGenderDto(block.getMalePopulation(),block.getFemalePopulation()))
				.collect(Collectors.toList());
	}
	
}
