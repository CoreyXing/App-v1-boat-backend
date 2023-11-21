package com.example.boatneo4j.controller;

import com.example.boatneo4j.pojo.VitaminNode;
import com.example.boatneo4j.service.VitaminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vitamin")
public class VitaminController {
    VitaminService vitaminService;

    @GetMapping("/getInfoById")
    public VitaminNode getInfoById(String id) {
        return vitaminService.getInfoById(id);
    }
}
