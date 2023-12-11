package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/getbyid/{id}")
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

    @GetMapping("/getbyclass")
    public List<Food> getFoodsByClass(@RequestParam String firstclass,
                                      @RequestParam String secondclass) {
        return foodService.getFoodsByClass(firstclass, secondclass);
    }

    @GetMapping("/getbyname/{name}")
    public List<Food> getFoodsByName(@PathVariable String name){
        return foodService.getFoodsByName(name);
    }

    @GetMapping  ("/secondclass")
    public Set<String> getSecondClassByFirstClass(@RequestParam String firstclass){
        return foodService.getSecondClassByFirstClass(firstclass);
    }

    @GetMapping("/firstclass")
    public Set<String> getAllFirstClass(){
        return foodService.getAllFirstClass();
    }

}
