package com.backend.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.backend.server.model.User;
import com.backend.server.service.JwtService;

@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtService jwtService;
	
	@PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody User user){
		try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
            	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String token = jwtService.generateToken(userDetails);
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Logged in successfully");
                response.put("username", userDetails.getUsername());
                response.put("roles", jwtService.extractRoles(token));
                response.put("token", token);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(400).body("Bad Credentials");
            }

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Bad Credentials");
        }
    }
}
