package com.ecust.appv1boatbackend.service.impl;

import com.ecust.appv1boatbackend.Repository.AthleteInfoRepository;
import com.ecust.appv1boatbackend.model.pojo.AthleteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2024/5/9 11:38
 */
@Service
public class AthleteInfoSeviceImpl implements AthleteInfoService{

    @Autowired
    private AthleteInfoRepository athleteInfoRepository;


    @Override
    public AthleteInfo getAthleteInfoById(String id) {
        return athleteInfoRepository.getAthleteInfoBy(id);
    }
}
