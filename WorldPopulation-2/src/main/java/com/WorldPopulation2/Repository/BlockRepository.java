package com.WorldPopulation2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.BlockNumber;

@Repository
public interface BlockRepository extends JpaRepository<BlockNumber,Integer>{
	List<BlockNumber> findByCountrycodeAndStatecodeAndBlockNumber(String countrycode, String statecode, int blockNumber);
	
	
}

