package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.model.DTO.RequestDto;
import com.ecust.appv1boatbackend.model.POJO.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        return foodService.getFoodById(id);
    }

    @PostMapping
    public void createFood(@RequestBody Food food) {
        foodService.createFood(food);
    }

    @PutMapping("/{id}")
    public void updateFood(@PathVariable int id, @RequestBody Food food) {
        food.setId(id);
        foodService.updateFood(food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id) {
        foodService.deleteFood(id);
    }

    @PostMapping("/search")
    public List<Food> getFoodsByClass(@RequestBody RequestDto requestDto) {
        String firstClass = requestDto.getFirstClass();
        String secondClass = requestDto.getSecondClass();
        return foodService.getFoodsByClass(firstClass, secondClass);
    }
}
