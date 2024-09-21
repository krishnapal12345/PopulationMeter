package com.WorldPopulation2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.WorldPopulation2.Entity.User;
import com.WorldPopulation2.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		User Users=new User(user.getUsername(),passwordEncoder.encode(user.getPassword()),user.getRole(),user.getFullname());
		
		return userRepository.save(Users);
	}

}
