package com.ecust.appv1boatbackend.controller;


import com.ecust.appv1boatbackend.model.dto.IngredientAndNutrientyDTO;
import com.ecust.appv1boatbackend.model.dto.MealInfoDTO;
import com.ecust.appv1boatbackend.model.dto.QueryMealInfoRequestDTO;
import com.ecust.appv1boatbackend.model.pojo.Meal;
import com.ecust.appv1boatbackend.model.dto.QueryIngredientDTO;
import com.ecust.appv1boatbackend.model.pojo.MealDishInfo;
import com.ecust.appv1boatbackend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {


    @Autowired
    private MealService mealService;


    @PostMapping("/accept")
    public ResponseEntity<IngredientAndNutrientyDTO> writeServiceForMeal(@RequestBody Meal meal){
        IngredientAndNutrientyDTO ingredientAndNutrientyDTO = mealService.receiveMeal(meal);
        return ResponseEntity.ok().body(ingredientAndNutrientyDTO);
    }
    @PostMapping("/dish")
    public  ResponseEntity<MealInfoDTO> queryMealInfoByUserIdAndDate(
            @RequestBody QueryMealInfoRequestDTO queryMealInfoRequestDTO){
        List<Meal> modifyMeals = mealService.queryMealInfo(queryMealInfoRequestDTO.getUserid(), queryMealInfoRequestDTO.getDate());
        List<MealDishInfo> modifyMealDishInfo = new ArrayList<>();
        modifyMeals.forEach(meal -> {
            modifyMealDishInfo.addAll(meal.getDishIds());
        });
        MealInfoDTO mealInfoDTO = new MealInfoDTO(modifyMealDishInfo,queryMealInfoRequestDTO.getDate());
        return ResponseEntity.ok().body(mealInfoDTO);
    }

    @PostMapping("/ingredient")
    public ResponseEntity<IngredientAndNutrientyDTO> queryIngredient(@RequestBody QueryIngredientDTO queryIngredientDTO){
        IngredientAndNutrientyDTO ingredientAndNutrientyDTO = mealService.getIngredientAndNutrientyUserIdAndDate(queryIngredientDTO.getId(), queryIngredientDTO.getDate());
        return ResponseEntity.ok().body(ingredientAndNutrientyDTO);
    }
}
