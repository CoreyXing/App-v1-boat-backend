package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.MineralsNode;
import com.example.boatneo4j.service.MineralsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minerals")
public class MineralsController {
    MineralsService mineralsService;

    @GetMapping("/getInfoById")
    public MineralsNode getInfoById(String id) {
        return mineralsService.getInfoById(id);
    }
}
