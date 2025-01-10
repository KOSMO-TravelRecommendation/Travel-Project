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
    private List<String> latestSurveyData;
    private List<Map<String, Object>> latestPredictions;
    
    @PostMapping("/submit")
    public ResponseEntity<?> submitSurvey(@RequestBody Map<String, Object> requestBody) {
        try {
            logger.info("Received survey data: {}", requestBody);
            
            List<String> surveyAnswers = (List<String>) requestBody.get("inputs");
            String modelType = (String) requestBody.get("modelType"); // 모델 타입 받기
            this.latestSurveyData = surveyAnswers;
            this.latestPredictions = null;
            
            logger.info("Stored survey data: {}", this.latestSurveyData);
            logger.info("Model type: {}", modelType);
            
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "설문이 성공적으로 처리되었습니다.",
                "data", surveyAnswers,
                "modelType", modelType
            ));
            
        } catch (Exception e) {
            logger.error("Error processing survey: ", e);
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }
    
    @PostMapping("/predictions")
    public ResponseEntity<?> savePredictions(@RequestBody Map<String, Object> requestBody) {
        try {
            logger.info("Received prediction results: {}", requestBody);
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> predictions = (List<Map<String, Object>>) requestBody.get("predictions");
            this.latestPredictions = predictions;
            
            logger.info("Stored prediction results: {}", this.latestPredictions);
            
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "예측 결과가 성공적으로 저장되었습니다.",
                "predictions", predictions
            ));
            
        } catch (Exception e) {
            logger.error("Error saving predictions: ", e);
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }
    
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestSurvey() {
        logger.info("Retrieving latest survey data: {}", latestSurveyData);
        logger.info("Retrieving latest predictions: {}", latestPredictions);
        
        if (latestSurveyData == null) {
            logger.warn("No survey data found");
            return ResponseEntity.notFound().build();
        }
        
        Map<String, Object> response = Map.of(
            "inputs", latestSurveyData,
            "predictions", latestPredictions != null ? latestPredictions : List.of()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/results")
    public ResponseEntity<?> getLatestResults() {
        logger.info("Retrieving latest prediction results: {}", latestPredictions);
        
        if (latestPredictions == null) {
            logger.warn("No prediction results found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Map.of("predictions", latestPredictions));
    }
    
    @GetMapping("/debug")
    public ResponseEntity<?> getDebugInfo() {
        Map<String, Object> debugInfo = Map.of(
            "surveyData", latestSurveyData != null ? latestSurveyData : "No survey data",
            "predictions", latestPredictions != null ? latestPredictions : "No predictions",
            "timestamp", System.currentTimeMillis()
        );
        
        logger.info("Debug info requested: {}", debugInfo);
        return ResponseEntity.ok(debugInfo);
    }
}