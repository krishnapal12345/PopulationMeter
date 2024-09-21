package com.WorldPopulation2.Controller;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.WorldPopulation2.Dto.EduGraphDto;
import com.WorldPopulation2.Dto.GraphGenderDto;
import com.WorldPopulation2.Entity.BlockPopulationDetails;
import  com.WorldPopulation2.Service.BlockService;
import com.WorldPopulation2.Service.BlockServiceImpl;
import com.WorldPopulation2.Service.ContactService;
import com.WorldPopulation2.Service.EducationalStat;
import com.WorldPopulation2.Service.GenderRatioStat;
import com.WorldPopulation2.Service.UserService;




@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private EducationalStat educationalStat;
	
	@Autowired
	private GenderRatioStat genderStat;
	
	private static  Logger logger=LoggerFactory.getLogger(UserController.class);
	

	@GetMapping("/user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
	@GetMapping("/get-Gender-graph")
	@ResponseBody
	public List<GraphGenderDto> getGenderData(@RequestParam("country")String country,@RequestParam("state")String state,@RequestParam("BlockNumber") int BlockNumber,Model model ){
		logger.info("calling  graph for country: {}, state: {}, block number: {}", country, state, BlockNumber);
		return genderStat.getGenderData(country, state, BlockNumber);
	}
	@GetMapping("/get-edu-graph")
	@ResponseBody
	public List<EduGraphDto> getEduData(@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("BlockNumber")int BlockNumber){
		logger.info("calling get-edu-graph for country: {}, state: {}, block number: {}", country, state, BlockNumber);
		return educationalStat.getEduData(country, state, BlockNumber);
	}
}
	

	
	

