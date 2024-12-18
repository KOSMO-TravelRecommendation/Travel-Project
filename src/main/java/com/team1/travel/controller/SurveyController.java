package com.team1.travel.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyController {

    @PostMapping("/submit-survey")
    public String submitSurvey(@RequestBody List<String> answers) {
        System.out.println("설문 응답: " + answers);
        
        return "설문이 성공적으로 제출되었습니다!";
    }
}
