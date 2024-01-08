package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> allFoods = foodService.getAllFoods();
        return ResponseEntity.ok(allFoods);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Food> getFoodById(
            @PathVariable String id) {
        Food food = foodService.getFoodById(id);
        return ResponseEntity.ok(food);
    }

    @GetMapping("/getbyclass")
    public ResponseEntity<List<Food>> getFoodsByClass(
            @RequestParam String firstclass,
            @RequestParam String secondclass) {
        List<Food> foods = foodService.getFoodsByClass(firstclass, secondclass);
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<Food>> getFoodsByName(
            @PathVariable String name) {
        List<Food> foods = foodService.getFoodsByName(name);
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/secondclass")
    public ResponseEntity<Set<String>> getSecondClassByFirstClass(
            @RequestParam String firstclass) {
        Set<String> secondClass = foodService.getSecondClassByFirstClass(firstclass);
        return ResponseEntity.ok(secondClass);
    }

    @GetMapping("/firstclass")
    public ResponseEntity<Set<String>> getAllFirstClass() {
        Set<String> allFirstClass = foodService.getAllFirstClass();
        return ResponseEntity.ok(allFirstClass);
    }

}
