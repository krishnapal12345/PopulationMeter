package com.WorldPopulation2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldPopulation2.Entity.User;
import com.WorldPopulation2.Service.UserService;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}

}
