package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.AthleteInfo;

/**
 * @author: Xingweicheng
 * @description: 查询运动员信息
 * @date: 2024/5/9 11:17
 */
public interface AthleteInfoRepository {

    AthleteInfo getAthleteInfoBy(String id);



}
