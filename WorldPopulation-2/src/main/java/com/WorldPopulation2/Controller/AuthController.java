package com.WorldPopulation2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.WorldPopulation2.Config.JwtHelper;
import com.WorldPopulation2.Entity.LoginResponse;
import com.WorldPopulation2.Entity.User;
import com.WorldPopulation2.Service.UserService;
import com.WorldPopulation2.payloads.JwtAuthRequest;
import com.WorldPopulation2.payloads.JwtAuthResponse;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            
          
            User savedUser = userService.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during registration: Please try again later.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request) {
        try {
           
            this.authenticate(request.getUsername(), request.getPassword());

            
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

            
            String token = this.jwtHelper.generateToken(userDetails);

            
            User user = userService.findByUsername(request.getUsername());

            
            JwtAuthResponse response = new JwtAuthResponse();
            response.setToken(token);
            response.setRole(user.getRole());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Login failed: Please try again later.");
        }
    }

   
    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);
    }
}
