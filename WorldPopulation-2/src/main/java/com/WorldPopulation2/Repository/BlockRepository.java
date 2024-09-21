package com.WorldPopulation2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.BlockPopulationDetails;

@Repository
public interface BlockRepository extends JpaRepository<BlockPopulationDetails,Integer>{
	List<BlockPopulationDetails> findByCountrycodeAndStatecodeAndBlockNumber(String countrycode, String statecode, int blockNumber);

	BlockPopulationDetails save(BlockPopulationDetails block);
	
	
}

