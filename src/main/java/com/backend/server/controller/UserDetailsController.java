package com.backend.server.controller;

import com.backend.server.model.LoginDto;
import com.backend.server.model.UserDetails;
import com.backend.server.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserDetailsController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @GetMapping("/getUsers")
    public List<UserDetails> getAllUsers(){
        return userDetailsRepository.findAll();
    }

    @PostMapping("/addUser")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody UserDetails user){
        UserDetails userDetails = userDetailsRepository.save(user);
        Map<String,String> response = new HashMap<>();
        if(userDetails!=null){
            response.put("status","200");
            response.put("message","User added successfully");
        } else{
            response.put("status","404");
            response.put("message","Error in storing user");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginDto loginDto){
        Map<String,Object> response = new HashMap<>();
        List<UserDetails> users = userDetailsRepository.findAll();
        if(null != users && users.size() > 0 ){
            for(int i=0;i< users.size();i++){
                if(users.get(i).getPhoneNumber().equals(loginDto.getUsername())
                && users.get(i).getPassword().equals(loginDto.getPassword())){
                    response.put("status",200);
                    response.put("message","login successful");
                    response.put("role",users.get(i).getProductCategory());
                    response.put("username", users.get(i).getFullName());
                    response.put("designation", users.get(i).getDesignation());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }
        }
        response.put("status",400);
        response.put("message","login failed");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
