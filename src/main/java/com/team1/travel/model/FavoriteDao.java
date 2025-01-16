package com.team1.travel.model;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface FavoriteDao {
    @Select("SELECT * FROM favorites WHERE userNo = #{userNo} ORDER BY created_at DESC LIMIT 1")
    FavoriteVo getLatestFavorite(int userNo);

    @Insert("INSERT INTO favorites (userNo, placeName, address) VALUES (#{userNo}, #{placeName}, #{address})")
    int addFavorite(FavoriteVo favorites);

    @Select("SELECT * FROM favorites WHERE userNo = #{userNo} ORDER BY created_at DESC")
    List<FavoriteVo> getUserFavorites(int userNo);
}
