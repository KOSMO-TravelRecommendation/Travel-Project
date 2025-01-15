package com.team1.travel.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 즐겨찾기 추가
    public boolean addFavorite(FavoriteVO favoriteVO) {
        String sql = "INSERT INTO favorites (userNo, place_name, address) VALUES (?, ?, ?)";
        
        try {
            jdbcTemplate.update(sql, favoriteVO.getUserNo(), favoriteVO.getPlaceName(), favoriteVO.getAddress());
            return true;  // 성공적으로 추가
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // 오류 발생
        }
    }
}
