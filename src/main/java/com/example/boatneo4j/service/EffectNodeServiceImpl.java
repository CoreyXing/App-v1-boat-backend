package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.EffectRepository;
import com.example.boatneo4j.pojo.EffectNode;

public class EffectNodeServiceImpl implements EffectNodeService {
    EffectRepository effectRepository;
    @Override
    public EffectNode getInfoById(String id) {
        return effectRepository.findById(id).get();
    }
}
