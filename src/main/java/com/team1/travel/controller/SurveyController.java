package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SurveyController {

    @GetMapping("/survey/form")
    public String surveyForm() {
        return "survey/surveyform";  // HTML 뷰를 반환
    }
    
    @GetMapping("/survey/results")
    public String showResults(Model model) {
        return "survey/surveyResult";
    }

}
