package com.WorldPopulation2.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Service.BlockService;

@Controller
public class AdminController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private BlockService blockService;

	@GetMapping("/admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		model.addAttribute("BlockPopulationDetails",new BlockPopulationDetails());
	    // Add this line
		return "admin";
	}
	
	@PostMapping("/submit-data")
	public String SaveData(@ModelAttribute("BlockPopulationDetails") BlockPopulationDetails details,@RequestParam("country")String country,@RequestParam("state")String state) {
	    // Use the details object to get the form data
	    blockService.SaveData(country,state, details.getBlockNumber(),
	                            details.getTotalPopulation(), details.getMalePopulation(), details.getFemalePopulation(),
	                            details.getTotalEducated(), details.getFemaleEducated(), details.getMaleEducated(),
	                            details.getAvgAge());
	    return "redirect:/admin-page";
	}
}
