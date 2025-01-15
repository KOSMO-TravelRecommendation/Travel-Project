package com.team1.travel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.travel.model.FavoritesDAO;
import com.team1.travel.model.FavoritesVO;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {
    
    @Autowired
    private FavoritesDAO favoritesDAO;
    
    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestBody FavoritesVO favorite) {
        try {
            // 이미 존재하는지 확인
            if (favoritesDAO.existsFavorite(favorite.getUserId(), favorite.getPlaceName(), favorite.getAddress())) {
                return ResponseEntity.ok(Map.of("success", false, "message", "이미 즐겨찾기에 추가된 장소입니다."));
            }
            
            // 즐겨찾기 추가
            favoritesDAO.addFavorite(favorite);
            return ResponseEntity.ok(Map.of("success", true, "message", "즐겨찾기에 추가되었습니다."));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("success", false, "message", "서버 오류가 발생했습니다."));
        }
    }
    
    @GetMapping("/list")
    public ResponseEntity<?> getFavorites(@RequestParam int userId) {
        try {
            List<FavoritesVO> favorites = favoritesDAO.getFavoritesByUserId(userId);
            return ResponseEntity.ok(favorites);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("success", false, "message", "서버 오류가 발생했습니다."));
        }
    }
    
    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<?> deleteFavorite(@PathVariable int favoriteId, @RequestParam int userId) {
        try {
            favoritesDAO.deleteFavorite(favoriteId, userId);
            return ResponseEntity.ok(Map.of("success", true, "message", "즐겨찾기가 삭제되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("success", false, "message", "서버 오류가 발생했습니다."));
        }
    }
}

