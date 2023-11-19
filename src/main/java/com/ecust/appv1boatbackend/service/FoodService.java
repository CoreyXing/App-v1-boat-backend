package com.ecust.appv1boatbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ecust.appv1boatbackend.bo.GetFoodByIdBO;
import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.vo.FoodQueryVo;

import java.util.List;

public interface FoodService extends IService<Food> {
    public List<FoodQueryVo> getAllFoods();
    public FoodQueryVo getFoodById(GetFoodByIdBO getFoodByIdBO);


}
