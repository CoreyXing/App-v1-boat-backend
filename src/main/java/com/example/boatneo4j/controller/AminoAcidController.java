package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.AminoAcidNode;
import com.example.boatneo4j.service.AminoAcidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aminoacid")
public class AminoAcidController {
    AminoAcidService aminoAcidService;

    @GetMapping("/getInfoById")
    public AminoAcidNode getInfoById(String id) {
        return aminoAcidService.getInfoById(id);
    }
}

