package com.wellsfargo.interviewtracker.service;

import java.util.List;

import com.wellsfargo.interviewtracker.dto.UserDTO;
import com.wellsfargo.interviewtracker.entity.User;

public interface UserService {
	
	public List<User> getAll();
	public User getByID(Long id);
	public UserDTO add(User user);
	public User delete(Long id);
	
}
