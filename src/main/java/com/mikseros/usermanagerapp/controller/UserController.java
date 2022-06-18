package com.mikseros.usermanagerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mikseros.usermanagerapp.model.User;
import com.mikseros.usermanagerapp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> listUsers = userService.listAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String showNewForm(Model model) {
		model.addAttribute("user", new User());
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes ra) {
		userService.save(user);
		ra.addFlashAttribute("message", "The user has been saved successfully");
		return "redirect:/users";
	}
}
