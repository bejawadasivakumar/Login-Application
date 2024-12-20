package com.example.demo;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Userdto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdetail", userDetails);
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model, Userdto userdto) {
	
		model.addAttribute("user",userdto);
		
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model, Userdto userdto) {
		model.addAttribute("user",userdto);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user") Userdto userdto,Model model) {
		User user = userService.findByUsername(userdto.getUsername());//duplicates not allowed int he database while registering
		if(user != null) {
			model.addAttribute("userexist",user);
			return "register";
		}
		userService.save(userdto);
		return "redirect:/register?success";
	}
}
