package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeaturesController {
	@GetMapping("/features/place")
    public String getPlacePage(Model model) {
        return "features/place";  
    }
	@GetMapping("/features/new")
    public String getNewPage(Model model) {
        return "/features/new";  
    }

}
