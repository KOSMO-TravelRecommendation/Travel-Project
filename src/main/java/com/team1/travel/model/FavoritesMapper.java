package com.team1.travel.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoritesMapper {

    @Insert("INSERT INTO favorites (user_no, place_name, place_address, place_type, place_score) " +
            "VALUES (#{userNo}, #{placeName}, #{placeAddress}, #{placeType}, #{placeScore})")
    int addFavorite(FavoriteVo favorite);
}
