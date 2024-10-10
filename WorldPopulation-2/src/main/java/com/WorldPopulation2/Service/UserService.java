package com.WorldPopulation2.Service;

import com.WorldPopulation2.Entity.User;

public interface UserService {

	User findByUsername(String username);
	User save(User user);
	
}
