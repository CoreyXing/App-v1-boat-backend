package com.ecust.appv1boatbackend.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ecust.appv1boatbackend.model.pojo.Food;


import java.util.List;

public interface FoodService extends IService<Food> {
    public List<Food> getAllFoods();
    public Food getFoodById(int id);


}
