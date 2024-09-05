package com.WorldPopulation2.Service;

import com.WorldPopulation2.Dto.UserDto;
import com.WorldPopulation2.Entity.User;

public interface UserService {

	User save(UserDto userDto);
	
}
