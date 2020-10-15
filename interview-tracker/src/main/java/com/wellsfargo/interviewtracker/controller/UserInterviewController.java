package com.wellsfargo.interviewtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interviewtracker.dto.UserInterviewDTO;
import com.wellsfargo.interviewtracker.service.UserInterviewService;

@RestController
@RequestMapping("/api")
public class UserInterviewController {
	
	@Autowired
	UserInterviewService userInterviewService;
	
	@GetMapping("/interviews/users")
	public ResponseEntity<List<UserInterviewDTO>> getAllUsersInterviews() {
		
		List<UserInterviewDTO> userInterviews = this.userInterviewService.getAllUserInterview();
		
		ResponseEntity<List<UserInterviewDTO>> response = new ResponseEntity<List<UserInterviewDTO>>(userInterviews, HttpStatus.OK);
		
		return response;
		
	}
	
	@PutMapping("/{user_id}/{interview_id}")
	public String addedInterviewUser( @PathVariable("user_id") Long user_id, @PathVariable("interview_id") Long interview_id) {
		
	
			this.userInterviewService.addUserIntrview(user_id, interview_id);
			return "Added";
			
		
		
		
		
	}
}
