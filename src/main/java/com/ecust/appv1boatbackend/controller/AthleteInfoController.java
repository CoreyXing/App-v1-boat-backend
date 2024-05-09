package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.model.dto.MealInfoDTO;
import com.ecust.appv1boatbackend.model.pojo.AthleteInfo;
import com.ecust.appv1boatbackend.service.impl.AthleteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Xingweicheng
 * @description: 查询运动员信息
 * @date: 2024/5/9 11:42
 */

@RestController
@RequestMapping("/api/athlete")
public class AthleteInfoController {

    @Autowired
    private AthleteInfoService athleteInfoService;

    @GetMapping("/info")
    public ResponseEntity<AthleteInfo> getAthleteInfo(@RequestParam String id){
        AthleteInfo athleteInfo = athleteInfoService.getAthleteInfoById(id);
        return ResponseEntity.ok().body(athleteInfo);
    }
}
