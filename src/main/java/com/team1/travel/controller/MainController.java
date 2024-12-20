package com.team1.travel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team1.travel.model.UserVo;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class MainController {

    // index page
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser"); 
        model.addAttribute("user", user); 
        return "index";
    }
    
    // AI 추천 페이지
    @GetMapping("/recommendation")
    public String recommendation(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser");
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "로그인이 필요한 서비스입니다.");
            return "redirect:/";  // 홈으로 리다이렉트
        }
        model.addAttribute("user", user);
        return "recommend";
    }
    
    // AI 추천 설문조사 페이지
    @GetMapping("recommendation/survey")
    public String surveyform(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser");
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "로그인이 필요한 서비스입니다.");
            return "redirect:/";  // 홈으로 리다이렉트
        }
        model.addAttribute("user", user);
        return "survey/surveyform";
    }
    
	
}
