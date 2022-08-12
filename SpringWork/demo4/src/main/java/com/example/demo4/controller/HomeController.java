package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo4.model.User;
import com.example.demo4.repository.UserRepository;
import com.example.demo4.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	@Autowired
	private UserService userService;
	
	private final UserRepository userRepository;
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/board/list";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error",required = false)String error) {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("register")
	public String register() {
		return "/user/join";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody User user) {
		if(userRepository.findByUsername(user.getUsername())!=null) {
			return "fail";
		}
		userService.register(user);
		return "success";
	}
}
