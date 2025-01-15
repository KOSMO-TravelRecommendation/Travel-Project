package com.team1.travel.model;

public class FavoriteVo {
    private int userNo;           // 사용자 ID
    private String placeName;     // 장소 이름
    private String placeAddress;  // 장소 주소
    private int placeType;        // 장소 유형
    private float placeScore;     // 장소 평점

    // getters and setters
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

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
    }

    public float getPlaceScore() {
        return placeScore;
    }

    public void setPlaceScore(float placeScore) {
        this.placeScore = placeScore;
    }
}
