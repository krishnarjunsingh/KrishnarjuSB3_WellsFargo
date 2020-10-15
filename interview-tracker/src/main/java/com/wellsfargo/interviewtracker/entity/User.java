package com.wellsfargo.interviewtracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	@Size(min = 5, max = 30, message = "First name must be between 5 and 30 characters")
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 25, message = "Last name must be between 3 and 25 characters")
	private String lastName;
	
	@NotNull
	@Email(message="Please enter valid email id")
	private String email;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Mobile number must be 10 digit")
	private String mobile;

	
}
