package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.VitaminRepository;
import com.example.boatneo4j.pojo.VitaminNode;

public class VitaminServiceImpl implements VitaminService {
    VitaminRepository vitaminRepository;
    @Override
    public VitaminNode getInfoById(String id) {
        return vitaminRepository.findById(id).get();
    }
}
