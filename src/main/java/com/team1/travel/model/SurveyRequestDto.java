package com.team1.travel.model;

import java.util.List;

public class SurveyRequestDto {

    private int userNo;
    private String age;
    private String region;
    private List<String> subRegion; // Make sure this field matches the data type
    private String travelers;
    private String budget;
    private String preference;
    private String transportation;

    // Getters and Setters
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(List<String> subRegion) {
        this.subRegion = subRegion;
    }

    public String getTravelers() {
        return travelers;
    }

    public void setTravelers(String travelers) {
        this.travelers = travelers;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }
}
