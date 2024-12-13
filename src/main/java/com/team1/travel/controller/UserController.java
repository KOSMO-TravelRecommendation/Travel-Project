package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

	@GetMapping("/user/signup")
	public String signupPage() {
		return "user/signup";
	}
	
}
