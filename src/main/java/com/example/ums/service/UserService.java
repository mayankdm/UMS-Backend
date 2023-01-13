package com.example.ums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ums.entity.User;
import com.example.ums.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public List<User> getUsers() {
		return repo.findAll();
	}
	public User getUserById(Long id) {
		return repo.findById(id).get();
	}

	public User updateUser(User user, Long id) {
		User _user = repo.findById(id).get();
		_user.setName(user.getName());
		_user.setEmail(user.getEmail());
		_user.setPhone(user.getPhone());
		_user.setUserName(user.getUserName());
		_user.setWebsite(user.getWebsite());
		return repo.save(user);
	}

	public void deleteUserById(Long id) {
		repo.deleteById(id);
	}
}
