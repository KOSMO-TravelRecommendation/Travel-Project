package com.team1.travel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1.travel.model.UserVo;
import com.team1.travel.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String signupPage() {
        return "user/signup";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String loginPage() {
        return "user/login";
    }

    // 회원가입
    @PostMapping("/")
    public String add(@ModelAttribute UserVo bean) {
        userService.add(bean);
        return "redirect:/";
    }

    // 이메일 중복 체크
    @PostMapping("/check-email")
    @ResponseBody
    public String checkEmail(@RequestParam String userEmail) {
        boolean isAvailable = userService.isEmailAvailable(userEmail);
        return isAvailable ? "available" : "exists";
    }

    // 로그인
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String userEmail, @RequestParam String userPw, 
            HttpSession session) {
        UserVo user = userService.login(userEmail, userPw);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "success";
        } else {
            return "fail";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
