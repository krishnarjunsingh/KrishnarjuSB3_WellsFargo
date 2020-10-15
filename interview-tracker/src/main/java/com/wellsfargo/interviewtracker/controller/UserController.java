package com.wellsfargo.interviewtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interviewtracker.dto.UserDTO;
import com.wellsfargo.interviewtracker.entity.User;
import com.wellsfargo.interviewtracker.exception.NotFoundException;
import com.wellsfargo.interviewtracker.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> users = this.service.getAll();
		
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
		return response;
		
	}
	
	
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUsers(@RequestBody User user) {
		
		UserDTO addUser = this.service.add(user);
		
		ResponseEntity<UserDTO> response = new ResponseEntity<UserDTO>(addUser, HttpStatus.OK);
		
		return response;
		
	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUserByID(@PathVariable("id") Long id) {
		
		User user = this.service.delete(id);
		
		if(user == null) {
			throw new NotFoundException("User not found with ID - "+id);
		}
		
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		
		return response;
		
	}
	
}
