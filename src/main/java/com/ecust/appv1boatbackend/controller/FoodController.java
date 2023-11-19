package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.bo.GetFoodByIdBO;
import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import com.ecust.appv1boatbackend.vo.FoodQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("getFood")
    public FoodQueryVo getFoodById(@Valid @RequestBody GetFoodByIdBO getFoodByIdBO) {return foodService.getFoodById(getFoodByIdBO);}
    @GetMapping("gerAllFoods")
    public List<FoodQueryVo> getAllFoods() {return foodService.getAllFoods();
    }


    }
}
