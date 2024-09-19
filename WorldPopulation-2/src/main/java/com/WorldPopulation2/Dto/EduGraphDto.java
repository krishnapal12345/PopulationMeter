package com.WorldPopulation2.Dto;

import lombok.Data;

@Data
public class EduGraphDto {

	private int femaleValue;
	private int maleValue;
	
	public EduGraphDto(int maleValue, int femaleValue) {
		// TODO Auto-generated constructor stub
		this.maleValue=maleValue;
		this.femaleValue=femaleValue;
	}

}
