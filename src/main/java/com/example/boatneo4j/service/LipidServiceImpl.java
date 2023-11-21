package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.LipidRepository;
import com.example.boatneo4j.pojo.LipidNode;

public class LipidServiceImpl implements LipidService {
    LipidRepository lipidRepository;
    @Override
    public LipidNode getInfoById(String id) {
        return lipidRepository.findById(id).get();
    }
}
