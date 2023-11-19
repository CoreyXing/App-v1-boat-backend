package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/foods")
@Api(tags = "食品查询")
@Validated
public class FoodController {
    @Autowired
    private  FoodService foodService;

    @ApiOperation("通过id查询食物")
    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {return foodService.getFoodById(id);}
    @GetMapping("/all")
    public List<Food> getAllFoods() {return foodService.getAllFoods();
    }


    }

