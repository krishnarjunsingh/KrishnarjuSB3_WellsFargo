package com.wellsfargo.interviewtracker.service;

import java.util.List;

import com.wellsfargo.interviewtracker.entity.Interview;

public interface InterviewService {
	
	public List<Interview> getAllInterview();
	public Interview getByInterviewID(Long id);
	public Interview getByInterviewerName(String interviewerName);
	public Interview getByInterviewName(String interviewName);
	public Interview addInterview(Interview interview);
	public void updateInterviewStatus(Long interviewId, String interviewStatus);
	public Interview delelteInterview(Long id);
	public Long totalInterviewCount();
}
