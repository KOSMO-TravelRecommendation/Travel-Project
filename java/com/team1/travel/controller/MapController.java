package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	
	  @RequestMapping("/map")
	    public String mapPage() {
	        return "map/map"; // map 폴더 안의 map.html
	    }
}