package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.SecondLevelFoodRepository;
import com.example.boatneo4j.pojo.SecondLevelFoodNode;

public class SecondLevelFoodServiceImpl implements SecondLevelFoodService {
    SecondLevelFoodRepository secondLevelFoodRepository;
    @Override
    public SecondLevelFoodNode getInfoById(String id) {
        return secondLevelFoodRepository.findById(id).get();
    }
}
