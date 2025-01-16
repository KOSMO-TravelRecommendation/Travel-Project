package com.team1.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.travel.model.FavoriteDao;
import com.team1.travel.model.FavoriteVO;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    public FavoriteVO getLatestFavorite(int userNo) {
        return favoriteDao.getLatestFavorite(userNo);
    }

    public boolean addFavorite(FavoriteVO favorite) {
        return favoriteDao.addFavorite(favorite) > 0;
    }
}
