package com.wellsfargo.interviewtracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.interviewtracker.dao.InterviewDAO;
import com.wellsfargo.interviewtracker.entity.Interview;
import com.wellsfargo.interviewtracker.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	InterviewDAO interviewDAO;
	
	@Override
	public List<Interview> getAllInterview() {
		// TODO Auto-generated method stub
		return this.interviewDAO.findAll();
	}

	@Override
	public Interview getByInterviewID(Long id) {
		// TODO Auto-generated method stub
		return this.interviewDAO.findById(id).orElse(null);
	}

	@Override
	public Interview addInterview(Interview interview) {
		// TODO Auto-generated method stub
		return this.interviewDAO.save(interview);
	}

	@Override
	@Transactional
	public void updateInterviewStatus(Long interviewId, String interviewStatus) {
		// TODO Auto-generated method stub
		
		this.interviewDAO.addInterviewStatus(interviewId, interviewStatus);
	
	}

	@Override
	public Interview delelteInterview(Long id) {
		// TODO Auto-generated method stub
		Interview interview = this.getByInterviewID(id);
		if(interview != null)
			this.interviewDAO.deleteById(id);
		return interview;
	}

	@Override
	public Interview getByInterviewerName(String interviewerName) {
		// TODO Auto-generated method stub
		return this.interviewDAO.findByInterviewerName(interviewerName);
	}

	@Override
	public Interview getByInterviewName(String interviewName) {
		// TODO Auto-generated method stub
		return this.interviewDAO.findByInterviewName(interviewName);
	}

	@Override
	public Long totalInterviewCount() {
		// TODO Auto-generated method stub
		return this.interviewDAO.count();
	}
}
