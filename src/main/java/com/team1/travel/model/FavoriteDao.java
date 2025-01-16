package com.team1.travel.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Mapper
public interface FavoriteDao {

    @Select("SELECT * FROM favorites WHERE userNo = #{userNo} ORDER BY created_at DESC LIMIT 1")
    FavoriteVO getLatestFavorite(int userNo);

    @Insert("INSERT INTO favorites (userNo, place_name, address) VALUES (#{userNo}, #{placeName}, #{address})")
    int addFavorite(FavoriteVO favorites);
}

