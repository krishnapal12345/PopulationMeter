package com.WorldPopulation2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="BlockNumber")
public class BlockNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int blockNumber;
	private String statecode;
	private String countrycode;
	private int TotalPopulation;
	private int MalePopulation;
	private int FemalePopulation;
	private int TotalEducated;
	private int MaleEducated;
	private int FemaleEducated;
	private int AvgAge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getblockNumber() {
		return blockNumber;
	}
	public void setblockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public int getTotalPopulation() {
		return TotalPopulation;
	}
	public void setTotalPopulation(int totalPopulation) {
		TotalPopulation = totalPopulation;
	}
	public int getMalePopulation() {
		return MalePopulation;
	}
	public void setMalePopulation(int malePopulation) {
		MalePopulation = malePopulation;
	}
	public int getFemalePopulation() {
		return FemalePopulation;
	}
	public void setFemalePopulation(int femalePopulation) {
		FemalePopulation = femalePopulation;
	}
	public int getTotalEducated() {
		return TotalEducated;
	}
	public void setTotalEducated(int totalEducated) {
		TotalEducated = totalEducated;
	}
	public int getMaleEducated() {
		return MaleEducated;
	}
	public void setMaleEducated(int maleEducated) {
		MaleEducated = maleEducated;
	}
	public int getFemaleEducated() {
		return FemaleEducated;
	}
	public void setFemaleEducated(int femaleEducated) {
		FemaleEducated = femaleEducated;
	}
	public int getAvgAge() {
		return AvgAge;
	}
	public void setAvgAge(int avgAge) {
		AvgAge = avgAge;
	}
	public BlockNumber() {
		
		// TODO Auto-generated constructor stub
	}

	public BlockNumber(int blockNumber, String statecode, String countrycode, int totalPopulation,
			int malePopulation, int femalePopulation, int totalEducated, int maleEducated, int femaleEducated,
			int avgAge) {
		
		this.blockNumber = blockNumber;
		this.statecode = statecode;
		this.countrycode = countrycode;
		this.TotalPopulation = totalPopulation;
		this.MalePopulation = malePopulation;
		this.FemalePopulation = femalePopulation;
		this.TotalEducated = totalEducated;
		this.MaleEducated = maleEducated;
		this.FemaleEducated = femaleEducated;
		this.AvgAge = avgAge;
	}

	
	

}
