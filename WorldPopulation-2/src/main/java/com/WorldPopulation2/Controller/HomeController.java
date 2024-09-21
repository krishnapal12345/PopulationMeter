package com.WorldPopulation2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}

}
