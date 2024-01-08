package com.ecust.appv1boatbackend.controller;


import com.ecust.appv1boatbackend.model.dto.Meal;
import com.ecust.appv1boatbackend.model.dto.QueryIngredientDTO;
import com.ecust.appv1boatbackend.model.pojo.Ingredient;
import com.ecust.appv1boatbackend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meals")
public class MealController {


    @Autowired
    private MealService mealService;


    @PostMapping("/accept")
    public ResponseEntity<Void> writeServiceForMeal(@RequestBody Meal meal){
        mealService.receiveMeal(meal);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/ingredient")
    public ResponseEntity<Ingredient> queryIngredient(@RequestBody QueryIngredientDTO queryIngredientDTO){
        Ingredient ingredient = mealService.getIngredientByUserIdAndDate(queryIngredientDTO.getId(), queryIngredientDTO.getDate());
        return ResponseEntity.ok().body(ingredient);
    }
}
