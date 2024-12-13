package com.team1.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.travel.model.UserVo;
import com.team1.travel.service.UserService;


@Controller
public class UserController {

	@GetMapping("/user/signup")
	public String signupPage() {
		return "user/signup";
	}
	
    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/")
    public String add(@ModelAttribute UserVo bean) {
        userService.add(bean);  // 회원가입 처리
        return "redirect:/";  // 홈 페이지로 리다이렉트
    }

    // 중복 이메일 체킹
    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmail(@RequestParam String userEmail) {
        boolean isAvailable = userService.isEmailAvailable(userEmail);  // 이메일 중복 체크
        return isAvailable ? ResponseEntity.ok("available") : ResponseEntity.ok("exists");  // 결과 반환
    }
	
}
