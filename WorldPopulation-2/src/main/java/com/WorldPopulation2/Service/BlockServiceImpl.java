package com.WorldPopulation2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Dto.BlockDto;
import com.WorldPopulation2.Entity.BlockNumber;
import com.WorldPopulation2.Repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired 
	private BlockRepository blockRepository;
	
	@Override
	public  BlockNumber save(BlockDto blockDto) {
		BlockNumber block=new BlockNumber(blockDto.getblockNumber(),blockDto.getStatecode(),blockDto.getCountrycode(),blockDto.getTotalPopulation(),blockDto.getMalePopulation(),blockDto.getFemalePopulation(),blockDto.getTotalEducated(),blockDto.getMaleEducated(),blockDto.getFemaleEducated(),blockDto.getAvgAge());
		
		 return blockRepository.save(block);
	}
	
	public List<BlockNumber> getBlockNumberDetails(String countrycode, String statecode, int blockNumber) {
		System.out.println("Blocknumber:"+blockNumber);
        return blockRepository.findByCountrycodeAndStatecodeAndBlockNumber(countrycode, statecode, blockNumber);
    }
	
	public List<BlockNumber> getAllData(String countrycode,String statecode,int blockNumber){
		return blockRepository.findByCountrycodeAndStatecodeAndBlockNumber(countrycode, statecode, blockNumber);
	}

}
