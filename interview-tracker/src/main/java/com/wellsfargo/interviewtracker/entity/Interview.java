package com.wellsfargo.interviewtracker.entity;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long interviewId;
	
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
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	@JoinTable(name = "USER_INTERVIEW", joinColumns = { @JoinColumn(name="INTERVIEW_ID")}, inverseJoinColumns = { @JoinColumn(name="USER_ID") })
	private List<User> usersID;
	
}
