package com.team1.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {

    // 맵을 표시하는 페이지를 반환하는 메서드
    @GetMapping("/map")
    public String showMapPage(@RequestParam("location") String location,
                               @RequestParam("lat") double lat,
                               @RequestParam("lng") double lng) {
        // map 폴더 내 map.html을 반환
        return "map/map";  // resources/templates/map/map.html을 반환
    }
}
