package com.team1.travel.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SurveyDao {

    // 설문 응답 저장
    @Insert({
        "<script>",
        "INSERT INTO survey_answers (userNo, age, region, sub_region, travelers, budget, preference, transportation) ",
        "VALUES (#{userNo}, #{age}, #{region}, ",
        "<foreach collection='subRegion' item='sub' open='[' separator=',' close=']'>",
        "#{sub}",
        "</foreach>, ",
        "#{travelers}, #{budget}, #{preference}, #{transportation})",
        "</script>"
    })
    int saveSurvey(@Param("userNo") int userNo,
                   @Param("age") String age,
                   @Param("region") String region,
                   @Param("subRegion") List<String> subRegion,
                   @Param("travelers") String travelers,
                   @Param("budget") String budget,
                   @Param("preference") String preference,
                   @Param("transportation") String transportation);
}
