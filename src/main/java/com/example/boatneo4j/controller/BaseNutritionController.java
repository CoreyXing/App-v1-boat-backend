package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.BaseNutritionNode;
import com.example.boatneo4j.service.BaseNutritionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseNutrition")
public class BaseNutritionController {
    BaseNutritionService baseNutritionService;

    @GetMapping("/getInfoById")
    public BaseNutritionNode getInfoById(String id) {
        return baseNutritionService.getInfoById(id);
    }
}
