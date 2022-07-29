package com.example.User_Management_System.Service;

import java.util.List;

import com.example.User_Management_System.Entity.User;

public interface UserService {
	
	List<User> getAllUsers();

	User getUserById(Long id);

	User saveUser(User user);

	void updateUser(User exUser);

	void deleteUserById(Long id);

}
