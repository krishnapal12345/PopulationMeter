package com.WorldPopulation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation2.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);
	
}
