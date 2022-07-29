package com.example.User_Management_System.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.User_Management_System.Entity.User;
import com.example.User_Management_System.Service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users")
	public String userList(Model model)
	{
		model.addAttribute("users",userService.getAllUsers());
		return "users";
	}
	
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/users/add")
	public String adduser(Model model)
	{
		User user = new User();
		model.addAttribute(user);
		return "adduser";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable Long id,Model model)
	{
		model.addAttribute("user",userService.getUserById(id));
		return "edituser";
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user)
	{
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user,Model model )
	{
		User exUser = userService.getUserById(id);
		exUser.setId(user.getId());
		exUser.setFirstName(user.getFirstName());
		exUser.setLastName(user.getLastName());
		exUser.setEmail(user.getEmail());
		exUser.setTelephone(user.getTelephone());
		
		userService.updateUser(exUser);
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		userService.deleteUserById(id);
		return "redirect:/users";
	}
}
