package com.WorldPopulation2.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WorldPopulation2.Entity.BlockPopulationDetails;
import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.CountryRepository;
import com.WorldPopulation2.Repository.StateRepository;
import com.WorldPopulation2.Service.BlockService;
import com.WorldPopulation2.Service.CountryService;
import com.WorldPopulation2.Service.StateService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private BlockService blockService;
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private StateService stateService;

    @Autowired
    private StateRepository stateRepository; // Inject the StateRepository

    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("BlockPopulationDetails", new BlockPopulationDetails());
        return "admin";
    }

    @PostMapping("/submit-data")
    public ResponseEntity<String> SaveData(@RequestBody BlockPopulationDetails blockPopulationDetails,@RequestParam("countryName")String countryName,@RequestParam("stateName")String stateName){
    	try {
    	
  
    		System.out.println("country-"+ countryName);
    		System.out.println("state-"+stateName);
    		countryService.saveCountryData(countryName);
    		stateService.saveStateData(stateName, countryName);
    		
    		blockService.saveBlockData(blockPopulationDetails, countryName, stateName);
    		
    		return ResponseEntity.ok("Data submitted succesfully");
    	}catch(EntityNotFoundException e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data submission failed: " + e.getMessage());
    	}
    }
}
