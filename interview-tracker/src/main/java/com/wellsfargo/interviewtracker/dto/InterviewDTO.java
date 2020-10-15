package com.wellsfargo.interviewtracker.dto;


import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewDTO {
	
	@NotNull
	@UniqueElements
	private Long interviewId;
	
	@NotNull
	@Size(min = 5, max = 30, message = "Interviewer Name must be between 5 and 30 characters")
	private String interviewerName;
	
	@NotNull
	@Size(min = 3, max = 30, message = "Interview Name must be between 3 and 25 characters")
	private String interviewName;
	
	@NotNull
	@Size(min = 5, max = 30, message = "Skill must be between 3 and 25 characters")
	private String usersSkils;
	
	private Time time;
	private Date date;
	
	@NotNull
	@Size(min = 5, max = 100, message = "Status number must be 10 digit")
	private String interviewStatus;	
	
	@NotNull
	@Size(min = 5, max = 100, message = "Remarks number must be 10 digit")
	private String remarks;
}
