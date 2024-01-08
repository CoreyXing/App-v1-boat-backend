package com.ecust.appv1boatbackend.service.impl;


import com.ecust.appv1boatbackend.Repository.DishRepository;
import com.ecust.appv1boatbackend.model.pojo.Dish;
import com.ecust.appv1boatbackend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishRepository dishRepository;
    public List<Dish> getDishByCode(String code){
        return dishRepository.getDishByCode(code);
    }

    public Dish getDishById(String id){
        return dishRepository.getDishById(id);
    }

    public List<Dish> getDishByKeyWord(String keyWord){
        return dishRepository.getDishByKeyWords(keyWord);
    }
}
