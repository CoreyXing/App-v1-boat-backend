package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.BaseNutritionRepository;
import com.example.boatneo4j.pojo.BaseNutritionNode;

public class BaseNutritionServiceImpl implements BaseNutritionService {
    BaseNutritionRepository baseNutritionRepository;
    @Override
    public BaseNutritionNode getInfoById(String id) {
        return baseNutritionRepository.findById(id).get();
    }
}
