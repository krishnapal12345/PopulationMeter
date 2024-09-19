package com.WorldPopulation2.Dto;

import com.WorldPopulation2.Entity.BlockPopulationDetails;

import lombok.Data;

@Data
public class BlockDto {

	private int blockNumber;
	private String statecode;
	private String countrycode;
	private int totalPopulation;
	private int malePopulation;
	private int femalePopulation;
	private int totalEducated;
	private int maleEducated;
	private int femaleEducated;
	private int avgAge;

	 public BlockPopulationDetails toBlockPopulationDetails() {
	        return new BlockPopulationDetails(
	            this.blockNumber,
	            this.statecode,
	            this.countrycode,
	            this.totalPopulation,
	            this.malePopulation,
	            this.femalePopulation,
	            this.totalEducated,
	            this.maleEducated,
	            this.femaleEducated,
	            this.avgAge
	        );
	    }

}
