package com.wellsfargo.interviewtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interviewtracker.entity.Interview;
import com.wellsfargo.interviewtracker.exception.NotFoundException;
import com.wellsfargo.interviewtracker.service.InterviewService;

@RestController
@RequestMapping("/api")
public class InterviewController {

	@Autowired
	InterviewService interviewService;
	
	@GetMapping("/interviews")
	public ResponseEntity<List<Interview>> getAllUsers() {
		
		List<Interview> interviews = this.interviewService.getAllInterview();
		
		ResponseEntity<List<Interview>> response = new ResponseEntity<List<Interview>>(interviews, HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/interviews/counts")
	public ResponseEntity<Long> getCount() {
		
		Long count = this.interviewService.totalInterviewCount();
		
		ResponseEntity<Long> response = new ResponseEntity<Long>(count, HttpStatus.OK);
		
		return response;
		
	}
	@GetMapping("/interviews/by/{interviewerName}")
	public ResponseEntity<Interview> getUserByinterviewerName(@PathVariable("interviewerName") String interviewerName) {
		
		Interview interview = this.interviewService.getByInterviewerName(interviewerName);
		
		if(interview == null) {
			throw new NotFoundException("Interviewer Name not found with Name - " + interviewerName);
		}
		
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(interview, HttpStatus.OK);
		return response;
		
	}
	
	@GetMapping("/interviews/for/{interviewName}")
	public ResponseEntity<Interview> getUserByinterviewName(@PathVariable("interviewName") String interviewName) {
		
		Interview interview = this.interviewService.getByInterviewName(interviewName);
		
		if(interview == null) {
			throw new NotFoundException("Interview Name not found with Name - " + interviewName);
		}
		
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(interview, HttpStatus.OK);
		return response;
		
	}
	
	@PostMapping("/interviews")
	public ResponseEntity<Interview> addUsers(@RequestBody Interview interview) {
		
		Interview addInterview = this.interviewService.addInterview(interview);
		
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(addInterview, HttpStatus.OK);
		
		return response;
		
	}
	
	@PutMapping("/interviews/{interviewId}/{interviewStatus}")
	public String updateStatus(@PathVariable("interviewId") Long interviewId, @PathVariable("interviewStatus") String interviewStatus) {
		
		this.interviewService.updateInterviewStatus(interviewId, interviewStatus);
		
		
		return "Updated";
		
	}
	
	@DeleteMapping("/interviews/{id}")
	public ResponseEntity<Interview> deleteUserByID(@PathVariable("id") Long id) {
		
		Interview interview = this.interviewService.delelteInterview(id);
		
		if(interview == null) {
			throw new NotFoundException("Interview not found with ID - "+id);
		}
		
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(interview, HttpStatus.OK);
		
		return response;
		
	}
	
}
