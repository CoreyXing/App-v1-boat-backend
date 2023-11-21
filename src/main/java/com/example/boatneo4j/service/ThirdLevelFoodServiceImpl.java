package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.ThirdLevelFoodRepository;
import com.example.boatneo4j.pojo.ThirdLevelFoodNode;

public class ThirdLevelFoodServiceImpl implements ThirdLevelFoodService {
    ThirdLevelFoodRepository thirdLevelFoodRepository;
    @Override
    public ThirdLevelFoodNode getInfoById(String id) {
        return thirdLevelFoodRepository.findById(id).get();
    }
}
