package com.team1.travel.service;

import com.team1.travel.model.SurveyDao;
import com.team1.travel.model.SurveyRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    private SurveyDao surveyDao;

    public boolean saveSurvey(SurveyRequestDto surveyRequestDto) {
        // Save the survey using the DAO method
        int result = surveyDao.saveSurvey(surveyRequestDto.getUserNo(),
                                          surveyRequestDto.getAge(),
                                          surveyRequestDto.getRegion(),
                                          surveyRequestDto.getSubRegion(),
                                          surveyRequestDto.getTravelers(),
                                          surveyRequestDto.getBudget(),
                                          surveyRequestDto.getPreference(),
                                          surveyRequestDto.getTransportation());
        return result > 0; // If rows were affected, return true
    }
}
