package com.team1.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.travel.model.FavoriteDAO;
import com.team1.travel.model.FavoriteVO;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDAO favoriteDAO;

    // 즐겨찾기 추가 서비스 메서드
    public boolean addFavorite(int userNo, String placeName, String address) {
        FavoriteVO favoriteVO = new FavoriteVO(userNo, placeName, address);
        return favoriteDAO.addFavorite(favoriteVO);
    }
}
