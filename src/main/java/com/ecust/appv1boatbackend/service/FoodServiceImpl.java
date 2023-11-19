package com.ecust.appv1boatbackend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecust.appv1boatbackend.bo.GetFoodByIdBO;
import com.ecust.appv1boatbackend.mapper.FoodMapper;
import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.vo.FoodQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    private FoodMapper foodMapper;
    @Override
    public FoodQueryVo getFoodById(GetFoodByIdBO getFoodByIdBO) {
        return foodMapper.getFoodById(getFoodByIdBO.getId());

    }

    @Override
    public List<FoodQueryVo> getAllFoods() {
        return foodMapper.getAllFood();
    }
}

