package com.wellsfargo.interviewtracker.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.interviewtracker.dao.UserDAO;
import com.wellsfargo.interviewtracker.dto.UserDTO;
import com.wellsfargo.interviewtracker.entity.User;
import com.wellsfargo.interviewtracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	  private ModelMapper modelMapper;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDAO.findAll();
	}

	@Override
	public User getByID(Long id) {
		// TODO Auto-generated method stub
		return this.userDAO.findById(id).orElse(null);
	}

	@Override
	public UserDTO add(User user) {
		// TODO Auto-generated method stub
		return convertToUserDTO(this.userDAO.save(user));
	}

	@Override
	public User delete(Long id) {
		// TODO Auto-generated method stub
		User user = this.getByID(id);
		if(user != null)
			this.userDAO.deleteById(id);
		return user;
	}

	private UserDTO convertToUserDTO(User user) {
		UserDTO orderDto = modelMapper.map(user, UserDTO.class);
		   return orderDto;
		  }
}
