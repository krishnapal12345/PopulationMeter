package com.WorldPopulation2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.State;

@Repository
public interface BlockRepository extends JpaRepository<BlockPopulationDetails,Integer>{
	List<BlockPopulationDetails> findByBlockNumber(int blockNumber);
	
	
	@Query("SELECT b FROM BlockPopulationDetails b " +
	           "JOIN b.state s " +
	           "JOIN s.country c " +
	           "WHERE c.countryName = :countryName " +
	           "AND s.stateName = :stateName " +
	           "AND b.blockNumber = :blockNumber")
	    List<BlockPopulationDetails> findByCountryStateAndBlockNumber(
	        @Param("countryName") String countryName, 
	        @Param("stateName") String stateName, 
	        @Param("blockNumber") int blockNumber
	    );
	
	
}

