package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SurveyController {

    @GetMapping("/survey/form")
    public String surveyForm() {
        return "survey/surveyform";  // HTML 뷰를 반환
    }
    
//    @PostMapping("/survey/submitForm")
//    public String submitSurvey(@RequestBody List<String> answers) {
//        System.out.println("설문 응답: " + answers);
//        return "설문이 성공적으로 제출되었습니다!";
//    }
}
