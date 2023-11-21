package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.EffectNode;
import com.example.boatneo4j.service.EffectNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/effect")
public class EffectController {
    EffectNodeService effectNodeService;

    @GetMapping("/getInfoById")
    public EffectNode getInfoById(String id) {
        return effectNodeService.getInfoById(id);
    }
}
