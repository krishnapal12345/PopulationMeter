package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.BlockDto;
import com.WorldPopulation2.Entity.BlockNumber;

@Service
public interface BlockService {

	BlockNumber save(BlockDto blockdto);

	List<BlockNumber> getBlockNumberDetails(String countrycode, String statecode, int blockNumber);
 
	List<BlockNumber> getAllData(String countrycode,String statecode,int blockNumber);
}
