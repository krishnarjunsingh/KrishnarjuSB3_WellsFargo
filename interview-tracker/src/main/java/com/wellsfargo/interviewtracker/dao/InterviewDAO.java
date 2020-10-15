package com.wellsfargo.interviewtracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.interviewtracker.entity.Interview;

@Repository
public interface InterviewDAO extends JpaRepository<Interview, Long> {

	@Query("select s from Interview s where s.interviewerName=:interviewerName")
	Interview findByInterviewerName(@Param("interviewerName") String interviewerName);
	
	@Query("select s from Interview s where s.interviewName=:interviewName")
	Interview findByInterviewName(@Param("interviewName") String interviewName);
	
	@Modifying
	@Query("UPDATE Interview s SET s.interviewStatus=:interviewStatus where s.interviewId=:interviewId")
	void addInterviewStatus(@Param("interviewId") Long interviewId, @Param("interviewStatus") String interviewStatus);
}
