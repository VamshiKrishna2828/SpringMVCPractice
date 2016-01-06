package com.cmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmc.entity.User;
import com.cmc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String getUsers(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
		
	}
	
	@RequestMapping("/users/{id}")
	public String userDetail(Model model,@PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user_detail";
	}
	
	@RequestMapping("register")
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "user-register";
	}
}
