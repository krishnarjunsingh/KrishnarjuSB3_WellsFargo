package com.wellsfargo.interviewtracker.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.interviewtracker.dto.UserInterviewDTO;
import com.wellsfargo.interviewtracker.service.UserInterviewService;

@Service
public class UserInterviewServiceImpl implements UserInterviewService {
	
	@PersistenceContext
	@Autowired
	EntityManager entityManager;

	@Override
	public List<UserInterviewDTO> getAllUserInterview() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("Select * from USER_INTERVIEW");
		
		@SuppressWarnings("unchecked")
		List<UserInterviewDTO> userInterviewQuery = query.getResultList();
		return userInterviewQuery;
	}

	@Override
	@Modifying
	@Transactional
	public void addUserIntrview(Long user_id, Long interview_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		entityManager.createNativeQuery("INSERT INTO USER_INTERVIEW VALUES ("+user_id+", "+interview_id+")").executeUpdate();
		
				
			
	}

}
