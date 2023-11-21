package com.example.boatneo4j.service;

import com.example.boatneo4j.mapper.AminoAcidRepository;
import com.example.boatneo4j.pojo.AminoAcidNode;
import org.springframework.stereotype.Service;

@Service
public class AminoAcidServiceImpl implements AminoAcidService {
    AminoAcidRepository aminoAcidRepository;
    @Override
    public AminoAcidNode getInfoById(String id) {
            return aminoAcidRepository.findById(id).get();

        }
    }

