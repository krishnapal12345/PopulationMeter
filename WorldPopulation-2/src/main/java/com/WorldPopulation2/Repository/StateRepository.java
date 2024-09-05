package com.WorldPopulation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.State;



@Repository
public interface StateRepository extends JpaRepository<State,Integer>{

	State findBystatename(String statename);
}
