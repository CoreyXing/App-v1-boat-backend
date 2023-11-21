package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.MineralsRepository;
import com.example.boatneo4j.pojo.MineralsNode;

public class MineralsServiceImpl implements MineralsService {
    MineralsRepository mineralsRepository;
    @Override
    public MineralsNode getInfoById(String id) {
        return mineralsRepository.findById(id).get();
    }
}
