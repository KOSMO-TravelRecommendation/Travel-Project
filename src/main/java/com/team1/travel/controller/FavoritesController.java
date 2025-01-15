package com.team1.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.travel.model.FavoriteVo;
import com.team1.travel.service.FavoritesService;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestBody FavoriteVo favoriteVo) {
        boolean success = favoritesService.addFavorite(favoriteVo);
        if (success) {
            return ResponseEntity.ok("즐겨찾기 추가 성공");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("즐겨찾기 추가 실패");
        }
    }
}
