package com.team1.travel.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FavoritesVO {
    private int favoriteId;
    private int userId;
    private String placeName; 
    private String address;
    private LocalDateTime createdAt;
    
    // 기본 생성자
    public FavoritesVO() {}
    
    // 생성자 
    public FavoritesVO(int userId, String placeName, String address) {
        this.userId = userId;
        this.placeName = placeName;
        this.address = address;
    }
    
    // Getter와 Setter
    public int getFavoriteId() {
        return favoriteId;
    }
    
    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getPlaceName() {
        return placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}