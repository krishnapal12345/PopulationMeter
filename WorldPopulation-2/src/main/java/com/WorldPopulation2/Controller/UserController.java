package com.WorldPopulation2.Controller;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

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
import com.WorldPopulation2.Dto.UserDto;
import com.WorldPopulation2.Entity.BlockNumber;
import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.BlockRepository;
import com.WorldPopulation2.Repository.CountryRepository;
import com.WorldPopulation2.Repository.StateRepository;
import com.WorldPopulation2.Service.BlockService;
import com.WorldPopulation2.Service.BlockServiceImpl;
import com.WorldPopulation2.Service.CountryService;
import com.WorldPopulation2.Service.StateService;
import com.WorldPopulation2.Service.UserService;




@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private BlockServiceImpl blockServiceimpl;
	
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	
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
		model.addAttribute("BlockNumber",new BlockDto());
	    // Add this line
		return "admin";
	}
	@PostMapping("/submit-data")
	public String SubmitData(@ModelAttribute("BlockNumber")BlockDto blockDto,@RequestParam ("country") String country,@RequestParam ("state") String state,@RequestParam("BlockNumber") int BlockNumber) {  
	    System.out.println("Country name:"+country);
	    System.out.println("state name:"+state);
	   
	    blockDto.setCountrycode(country);
	    blockDto.setStatecode(state);
	    blockDto.setblockNumber(BlockNumber);
	    
	    
	    blockService.save(blockDto);
	   
	   return "redirect:/admin-page";
	}
	
	@GetMapping("/get-graph")
	@ResponseBody
	public List<Object[]> getBlockGraph(@RequestParam("country")String country,@RequestParam("state")String state,@RequestParam("BlockNumber") int BlockNumber,Model model ){
		return blockService.getAllData(country, state, BlockNumber).stream()
	            .map(block -> new Object[]{block.getMalePopulation(), block.getFemalePopulation()})
	            .collect(Collectors.toList());
	}
	@GetMapping("/get-edu-graph")
	@ResponseBody
	public List<Object[]> getEduData(@RequestParam("country") String country,@RequestParam("state") String state,@RequestParam("BlockNumber")int BlockNumber){
		return blockService.getAllData(country, state, BlockNumber).stream()
				.map(block -> new Object[] {block.getMaleEducated(),block.getFemaleEducated()})
				.collect(Collectors.toList());
	}
}
	

	
	

