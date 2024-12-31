package com.team1.travel.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class RestApiController {
	
	@GetMapping("/api/data")
	public String test() {
		return "React Api Test!";
	}
	
}
