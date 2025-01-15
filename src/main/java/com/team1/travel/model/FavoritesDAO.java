package com.team1.travel.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FavoritesDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // 즐겨찾기 추가
    public void addFavorite(FavoritesVO favorite) {
        String sql = "INSERT INTO favorites (user_id, place_name, address) VALUES (?, ?, ?)";
        
        jdbcTemplate.update(sql, 
            favorite.getUserId(),
            favorite.getPlaceName(),
            favorite.getAddress()
        );
    }
    
    // 사용자의 모든 즐겨찾기 조회
    @SuppressWarnings("deprecation")
	public List<FavoritesVO> getFavoritesByUserId(int userId) {
        String sql = "SELECT * FROM favorites WHERE user_id = ? ORDER BY created_at DESC";
        
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            FavoritesVO favorite = new FavoritesVO();
            favorite.setFavoriteId(rs.getInt("favorite_id"));
            favorite.setUserId(rs.getInt("user_id"));
            favorite.setPlaceName(rs.getString("place_name"));
            favorite.setAddress(rs.getString("address"));
            favorite.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return favorite;
        });
    }
    
    // 즐겨찾기 삭제
    public void deleteFavorite(int favoriteId, int userId) {
        String sql = "DELETE FROM favorites WHERE favorite_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, favoriteId, userId);
    }
    
    // 즐겨찾기 존재 여부 확인
    public boolean existsFavorite(int userId, String placeName, String address) {
        String sql = "SELECT COUNT(*) FROM favorites WHERE user_id = ? AND place_name = ? AND address = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, placeName, address);
        return count > 0;
    }
}