package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.FirstLevelFoodRepository;
import com.example.boatneo4j.pojo.FirstLevelFoodNode;

public class FirstLevelFoodNodeServiceImpl implements FirstLevelFoodNodeService {
    FirstLevelFoodRepository firstLevelFoodRepository;
    @Override
    public FirstLevelFoodNode getInfoById(String id) {
        return firstLevelFoodRepository.findById(id).get();
    }
}
