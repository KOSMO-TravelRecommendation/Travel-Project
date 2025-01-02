package com.team1.travel.controller;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // React 클라이언트의 URL
public class RestApiController {

	@PostMapping("/submitSurvey")
	public ResponseEntity<String> submitSurvey(@RequestBody Map<String, Object> requestBody) {
	    // 클라이언트에서 전달된 "inputs" 배열을 받아 처리
	    List<String> surveyAnswers = (List<String>) requestBody.get("inputs");

	    // 받은 데이터를 로그로 출력 (디버깅용)
	    System.out.println("서버에서 받은 설문 응답: " + surveyAnswers);

	    // 응답 생성
	    return ResponseEntity.ok("서버에 설문 결과가 전달되었습니다.");
	}


}
