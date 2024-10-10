package com.WorldPopulation2.Controller;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WorldPopulation2.Dto.EduGraphDto;
import com.WorldPopulation2.Dto.GraphGenderDto;
import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.State;
import  com.WorldPopulation2.Service.BlockService;
import com.WorldPopulation2.Service.BlockServiceImpl;
import com.WorldPopulation2.Service.ContactFormService;
import com.WorldPopulation2.Service.EducationalStat;
import com.WorldPopulation2.Service.GenderRatioStat;
import com.WorldPopulation2.Service.UserService;




@RestController
@RequestMapping("/api")
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
	
	
	@GetMapping("/get-edu-graph")
	@ResponseBody
	public List<EduGraphDto> getEduData(@RequestParam("countryName") String countryName,@RequestParam("stateName") String stateName,@RequestParam("blockNumber")int blockNumber){
		System.out.println("country:"+countryName);
		logger.info("calling get-edu-graph for country: {}, state: {}, block number: {}", countryName, stateName, blockNumber);
		return educationalStat.getEduData(countryName, stateName, blockNumber);
	}
	@GetMapping("/get-Data")
	@ResponseBody
	public ResponseEntity<List<BlockPopulationDetails>> getGraphData(@RequestParam("countryName") String countryName,@RequestParam("stateName") String stateName,@RequestParam("blockNumber")int blockNumber) {
		List<BlockPopulationDetails> blockDetails=educationalStat.getBlockPopulationDetails(countryName, stateName, blockNumber);
		 return ResponseEntity.ok(blockDetails);	
	}
	@GetMapping("/get-Gender-graph")
	@ResponseBody
    public List<GraphGenderDto> getGenderData(@RequestParam("countryName") String countryName,@RequestParam("stateName") String stateName,@RequestParam("blockNumber")int blockNumber){
		logger.info("calling get-Gender-graph for country: {}, state: {}, block number: {}", countryName, stateName, blockNumber);
		return genderStat.getGenderData(countryName, stateName, blockNumber);
	}
}
	

	
	

