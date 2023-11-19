package com.ecust.appv1boatbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecust.appv1boatbackend.mapper.FoodMapper;
import com.ecust.appv1boatbackend.model.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    private FoodMapper foodMapper;
    @Override
    public Food getFoodById(int id) {
        return foodMapper.selectById(id);

    }

    @Override
    public List<Food> getAllFoods() {
        return foodMapper.selectList(new QueryWrapper<>());
    }
}

