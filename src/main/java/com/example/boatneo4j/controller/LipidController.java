package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.LipidNode;
import com.example.boatneo4j.service.LipidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lipid")
public class LipidController {
    LipidService lipidService;

    @GetMapping("/getInfoById")
    public LipidNode getInfoById(String id) {
        return lipidService.getInfoById(id);
    }
}
