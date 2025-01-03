package com.team1.travel.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/survey")
public class RestApiController {
    
    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
    private List<String> latestSurveyData; // 최신 설문 데이터 저장
    
    @PostMapping("/submit")
    public ResponseEntity<?> submitSurvey(@RequestBody Map<String, Object> requestBody) {
        try {
            logger.info("Received survey data: {}", requestBody);
            
            List<String> surveyAnswers = (List<String>) requestBody.get("inputs");
            this.latestSurveyData = surveyAnswers; // 데이터 저장
            
            // React 서버로 데이터 전송
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "설문이 성공적으로 처리되었습니다.",
                "data", surveyAnswers
            ));
            
        } catch (Exception e) {
            logger.error("Error processing survey: ", e);
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }
    
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestSurvey() {
        if (latestSurveyData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Map.of("inputs", latestSurveyData));
    }
}