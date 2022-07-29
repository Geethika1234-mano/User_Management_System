package com.example.User_Management_System.Service.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Management_System.Entity.User;
import com.example.User_Management_System.Service.UserService;
import com.example.User_Management_System.UserRepository.UserRepository;

@Service
public class UserImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {

		return userRepo.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
	return	userRepo.save(user);
		
	}

	@Override
	public void updateUser(User exUser) {

		userRepo.save(exUser);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);		
	}

}
