package com.WorldPopulation2.Controller;

import java.security.Principal;
import java.util.List;

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
import com.WorldPopulation2.Entity.Country;
import com.WorldPopulation2.Entity.State;
import com.WorldPopulation2.Repository.CountryRepository;
import com.WorldPopulation2.Repository.StateRepository;
import com.WorldPopulation2.Service.BlockService;
import com.WorldPopulation2.Service.CountryService;
import com.WorldPopulation2.Service.StateService;

import jakarta.persistence.EntityNotFoundException;

@Controller
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
    public String saveBlockData(@ModelAttribute("BlockPopulationDetails") BlockPopulationDetails details,
                                 @RequestParam("countryName") String countryName,
                                 @RequestParam("statecode") String stateName
                                 ) {
        
    	try {
    	  countryService.saveCountryData(countryName);
    	  stateService.saveStateData(stateName, countryName);
          blockService.saveBlockData(details, countryName, stateName);
          return "redirect:/admin-page";
    }catch(EntityNotFoundException e) {
    	return "admin";
    }
    }
}
