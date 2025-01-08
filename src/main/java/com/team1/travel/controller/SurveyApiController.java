package com.team1.travel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SurveyApiController {

    // 설문 데이터를 React로 제공하는 API
    @GetMapping("/survey-results")
    public ResponseEntity<List<String>> getSurveyResults() {
        // 샘플 데이터 (추후 실제 데이터로 변경 가능)
        List<String> results = List.of("응답1", "응답2", "응답3", "응답4", "응답5", "응답6", "응답7");
        return ResponseEntity.ok(results);
    }

    // React에서 설문 데이터를 받는 API
    @PostMapping("/survey-submit")
    public ResponseEntity<String> submitSurvey(@RequestBody List<String> answers) {
        // 받은 데이터 확인 (콘솔 출력)
        System.out.println("받은 설문 응답: " + answers);
        
        // 응답 메시지 반환
        return ResponseEntity.ok("설문 데이터가 성공적으로 저장되었습니다!");
    }
}
