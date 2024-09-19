package com.WorldPopulation2.Entity;

import com.WorldPopulation2.Dto.BlockDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BlockPopulationDetails")
@Data
public class BlockPopulationDetails {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
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
	
    public BlockPopulationDetails(){
		
	}
	
	
	public BlockPopulationDetails(int blockNumber, String statecode, String countrycode, int totalPopulation,
			int malePopulation, int femalePopulation, int totalEducated, int maleEducated, int femaleEducated,
			int avgAge) {
		
		this.blockNumber = blockNumber;
		this.statecode = statecode;
		this.countrycode = countrycode;
		this.totalPopulation = totalPopulation;
		this.malePopulation = malePopulation;
		this.femalePopulation = femalePopulation;
		this.totalEducated = totalEducated;
		this.maleEducated = maleEducated;
		this.femaleEducated = femaleEducated;
		this.avgAge = avgAge;
	}
	
	public BlockDto toBlockDto() {
		BlockDto blockDto=new BlockDto();
		blockDto.setBlockNumber(this.blockNumber);
		blockDto.setStatecode(this.statecode);
		blockDto.setCountrycode(this.countrycode);
		blockDto.setTotalPopulation(this.totalPopulation);
		blockDto.setMalePopulation(this.malePopulation);
		blockDto.setFemalePopulation(this.femalePopulation);
		blockDto.setTotalEducated(this.totalEducated);
		blockDto.setMaleEducated(this.maleEducated);
		blockDto.setFemaleEducated(this.femaleEducated);
		blockDto.setAvgAge(this.avgAge);
		
		return blockDto;
		
		
	}
	
}
