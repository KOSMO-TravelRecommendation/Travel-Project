package com.team1.travel.controller;

import com.team1.travel.model.SurveyRequestDto;
import com.team1.travel.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    
    @PostMapping("/submit-survey")
    public String submitSurvey(@RequestBody SurveyRequestDto surveyRequestDto) {
        boolean success = surveyService.saveSurvey(surveyRequestDto);

        if (success) {
            return "redirect:/recommendation";
        } else {
            return "redirect:/error";
        }
    }
}
