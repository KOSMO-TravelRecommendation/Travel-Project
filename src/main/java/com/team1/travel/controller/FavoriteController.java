package com.team1.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team1.travel.model.FavoriteVO;
import com.team1.travel.service.FavoriteService;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 즐겨찾기 추가 요청 처리
    @PostMapping("/api/favorites/add")
    public ResponseEntity<String> addFavorite(@RequestBody FavoriteVO favoriteVO) {
        boolean isAdded = favoriteService.addFavorite(favoriteVO.getUserNo(), favoriteVO.getPlaceName(), favoriteVO.getAddress());

        if (isAdded) {
            return ResponseEntity.ok("즐겨찾기에 추가되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("즐겨찾기 추가 중 오류가 발생했습니다.");
        }
    }
}
