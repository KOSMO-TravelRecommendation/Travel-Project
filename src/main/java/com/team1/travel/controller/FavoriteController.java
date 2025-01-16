package com.team1.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.travel.model.FavoriteVO;
import com.team1.travel.service.FavoriteService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 최신 즐겨찾기 가져오기
    @GetMapping("/latest/{userNo}")
    public ResponseEntity<?> getLatestFavorite(@PathVariable int userNo) {
        try {
            FavoriteVO latestFavorite = favoriteService.getLatestFavorite(userNo);
            return ResponseEntity.ok(latestFavorite);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류 발생");
        }
    }

    // 즐겨찾기 추가
    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestBody FavoriteVO favoriteVO, @RequestParam int userNo) {
        try {
            favoriteVO.setUserNo(userNo);
            favoriteService.addFavorite(favoriteVO);
            return ResponseEntity.ok("즐겨찾기에 추가되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("즐겨찾기 추가 중 오류가 발생했습니다.");
        }
    }
}


