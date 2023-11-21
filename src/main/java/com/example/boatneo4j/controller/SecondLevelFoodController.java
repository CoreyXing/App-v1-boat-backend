package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.SecondLevelFoodNode;
import com.example.boatneo4j.service.SecondLevelFoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondlevelfood")
public class SecondLevelFoodController {
    SecondLevelFoodService secondLevelFoodService;

    @GetMapping("/getInfoById")
    public SecondLevelFoodNode getInfoById(String id) {
        return secondLevelFoodService.getInfoById(id);
    }
}

