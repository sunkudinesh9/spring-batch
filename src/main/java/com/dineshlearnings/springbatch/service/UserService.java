package com.dineshlearnings.springbatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineshlearnings.springbatch.model.User;
import com.dineshlearnings.springbatch.repository.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository userRespository;

	public User addUser(User user) {
		return userRespository.save(user);
	}

	public List<User> getAlluser() {
		return userRespository.findAll();
	}

}
