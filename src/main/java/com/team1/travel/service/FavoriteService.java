package com.team1.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.travel.model.FavoriteDao;
import com.team1.travel.model.FavoriteVo;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteDao favoriteDao;

	public FavoriteVo getLatestFavorite(int userNo) {
		return favoriteDao.getLatestFavorite(userNo);
	}

	public boolean addFavorite(FavoriteVo favorite) {
		return favoriteDao.addFavorite(favorite) > 0;
	}
	
	public List<FavoriteVo> getUserFavorites(int userNo) {
	    return favoriteDao.getUserFavorites(userNo);
	}
	
}