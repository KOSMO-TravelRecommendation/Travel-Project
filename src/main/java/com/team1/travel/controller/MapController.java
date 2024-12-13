package com.team1.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MapController {

    @GetMapping("/map/map")
    public String showMap() {
        return "map";  
    }
    
 // 추천 장소 데이터를 반환하는 API (머신러닝 추천 데이터 예시)
    @GetMapping("/map/recommendations")
    public List<Place> getRecommendations(@RequestParam String category, @RequestParam String location) {
        // 예시 데이터 (실제로는 머신러닝 모델에 의해 반환)
        List<Place> recommendations = new ArrayList<>();
        
        if ("food".equals(category)) {
            recommendations.add(new Place("서울타워", 37.551229, 126.988205));
            recommendations.add(new Place("경복궁", 37.577778, 126.976924));
        } else if ("tourist".equals(category)) {
            recommendations.add(new Place("북촌 한옥마을", 37.582224, 126.986907));
            recommendations.add(new Place("한강공원", 37.524114, 126.935738));
        } else {
            recommendations.add(new Place("카페 드롭탑", 37.495494, 127.029711));
            recommendations.add(new Place("스타벅스 강남", 37.498165, 127.027158));
        }

        return recommendations;
    }

    // Place 클래스: 추천 장소에 대한 정보를 저장하는 클래스
    class Place {
        private String name;
        private double lat;
        private double lng;

        public Place(String name, double lat, double lng) {
            this.name = name;
            this.lat = lat;
            this.lng = lng;
        }

        // getter, setter
        public String getName() { return name; }
        public double getLat() { return lat; }
        public double getLng() { return lng; }
    }
}
