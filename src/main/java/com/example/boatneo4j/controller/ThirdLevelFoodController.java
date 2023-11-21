package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.ThirdLevelFoodNode;
import com.example.boatneo4j.service.ThirdLevelFoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thirdlevelfood")
public class ThirdLevelFoodController {
    ThirdLevelFoodService thirdLevelFoodService;

    @GetMapping("/getInfoById")
    public ThirdLevelFoodNode getInfoById(String id) {
        return thirdLevelFoodService.getInfoById(id);
    }
}

