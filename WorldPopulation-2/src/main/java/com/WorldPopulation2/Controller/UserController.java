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

import com.WorldPopulation2.Dto.BlockDto;
import com.WorldPopulation2.Dto.ContactDto;
import com.WorldPopulation2.Dto.EduGraphDto;
import com.WorldPopulation2.Dto.GraphGenderDto;
import com.WorldPopulation2.Dto.UserDto;
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
	private UserService userService;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private BlockServiceImpl blockServiceimpl;
	
	@Autowired
	private EducationalStat educationalStat;
	
	@Autowired
	private GenderRatioStat genderStat;
	
	@Autowired
	private ContactService contactService;
	
	private static  Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto,Model model,@RequestParam("role") String role) {
		userDto.setRole(role);
		userService.save(userDto);
		model.addAttribute("message","Registered successfully");
		return "redirect:/login";
	}
	
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
	
	@GetMapping("/contact")
	public String contact(Model model) {
		logger.info("Navigating to contact page");
	    model.addAttribute("Contact", new ContactDto());
	    return "contact";
	}


	@GetMapping("/user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	@GetMapping("/admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		model.addAttribute("BlockPopulationDetails",new BlockDto());
	    // Add this line
		return "admin";
	}
	@PostMapping("/submit-data")
	public String SubmitData(@ModelAttribute("BlockPopulationDetails") BlockPopulationDetails details,@RequestParam("country")String country,@RequestParam("state")String state) {
	    // Use the details object to get the form data
	    blockService.SubmitData(country,state, details.getBlockNumber(),
	                            details.getTotalPopulation(), details.getMalePopulation(), details.getFemalePopulation(),
	                            details.getTotalEducated(), details.getFemaleEducated(), details.getMaleEducated(),
	                            details.getAvgAge());
	    return "redirect:/admin-page";
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

	@PostMapping("/submit-message")
	public String SubmitMessage(@ModelAttribute("Contact")ContactDto contactdto,@RequestParam("name")String name,@RequestParam("email") String email,@RequestParam("message")String message,Model model) {
		logger.info("Submitting message from user: {} with email: {}", name, email);
		contactService.SubmitMessage(email, name, message);
		
		model.addAttribute("message","message sent succesfully");
		
		return "redirect:/contact";
	}
}
	

	
	

