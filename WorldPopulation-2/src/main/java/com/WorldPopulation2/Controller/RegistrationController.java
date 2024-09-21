package com.WorldPopulation2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.WorldPopulation2.Entity.User;
import com.WorldPopulation2.Service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") User user) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") User user,Model model,@RequestParam("role") String role) {
		user.setRole(role);
		userService.save(user);
		model.addAttribute("message","Registered successfully");
		return "redirect:/login";
	}
}
