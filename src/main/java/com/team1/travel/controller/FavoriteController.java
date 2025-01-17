package com.team1.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.team1.travel.model.FavoriteVo;
import com.team1.travel.service.FavoriteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorites")  // 기본 경로 설정
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;  // FavoriteService 주입

    // 사용자의 최근 즐겨찾기 목록 조회
    @GetMapping("/{userNo}")
    public ResponseEntity<?> getUserFavorites(@PathVariable int userNo) {
        try {
            // 최근 즐겨찾기 목록을 조회
            List<FavoriteVo> favorites = favoriteService.getUserFavorites(userNo);
            
            // 즐겨찾기 목록이 없을 경우
            if (favorites.isEmpty()) {
                return ResponseEntity.status(204).body(Map.of(
                        "status", "success",
                        "message", "즐겨찾기 목록이 없습니다."
                ));
            }
            
            // 즐겨찾기 목록이 있을 경우
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "favorites", favorites
            ));
        } catch (Exception e) {
            // 예외 처리 및 에러 로깅
            return ResponseEntity.status(500).body(Map.of(
                    "status", "error",
                    "message", "즐겨찾기 조회 중 오류가 발생했습니다: " + e.getMessage()
            ));
        }
    }
    
    
}
