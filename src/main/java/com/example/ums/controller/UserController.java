package com.example.ums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ums.entity.User;
import com.example.ums.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user,@PathVariable Long id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}
}
