package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.FirstLevelFoodNode;
import com.example.boatneo4j.service.FirstLevelFoodNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstlevelfood")
public class FirstLevelFoodController {
    FirstLevelFoodNodeService firstLevelFoodNodeService;

    @GetMapping("/getInfoById")
    public FirstLevelFoodNode getInfoById(String id) {
        return firstLevelFoodNodeService.getInfoById(id);
    }
}

