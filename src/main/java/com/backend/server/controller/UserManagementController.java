package com.backend.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.server.model.User;
import com.backend.server.service.CustomeUserDetailsService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ADMIN')")
public class UserManagementController {
	
	@Autowired
	CustomeUserDetailsService userService;

	@GetMapping
	public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
	}

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
	
	@PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    @PutMapping("/{id}/roles")
    public ResponseEntity<User> updateRoles(@PathVariable String id, @RequestBody List<String> roles) {
        return ResponseEntity.ok(userService.updateRoles(id, roles));
    }
	
	//internal use only
	@DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(){
		userService.deleteAllUser();
        return new ResponseEntity<>("Deleted All User", HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable String id) {
	    userService.deleteUserById(id);
	    return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
}
