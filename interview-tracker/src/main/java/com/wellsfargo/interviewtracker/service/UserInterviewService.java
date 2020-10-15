package com.wellsfargo.interviewtracker.service;

import java.util.List;

import com.wellsfargo.interviewtracker.dto.UserInterviewDTO;

public interface UserInterviewService {
	
	public List<UserInterviewDTO> getAllUserInterview();
	
	public void addUserIntrview(Long user_id, Long interview_id);

}
