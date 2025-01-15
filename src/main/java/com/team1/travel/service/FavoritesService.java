package com.team1.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.travel.model.FavoriteVo;
import com.team1.travel.model.FavoritesMapper;

@Service
public class FavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;

    public boolean addFavorite(FavoriteVo favoriteVo) {
        int result = favoritesMapper.addFavorite(favoriteVo);
        return result > 0;  // 성공하면 true, 실패하면 false
    }
}
