package com.team1.travel.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FavoriteVO {
    private int favoriteId;
    private int userNo;
    private String placeName;
    private String address;
    private Timestamp createdAt;

    // Getter, Setter, Constructor
    public FavoriteVO(int userNo, String placeName, String address) {
        this.userNo = userNo;
        this.placeName = placeName;
        this.address = address;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
