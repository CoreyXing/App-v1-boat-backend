package com.ecust.appv1boatbackend.controller;


import com.alibaba.fastjson.JSONObject;
import com.ecust.appv1boatbackend.model.dto.MealInfoDTO;
import com.ecust.appv1boatbackend.model.dto.QueryMealInfoRequestDTO;
import com.ecust.appv1boatbackend.model.pojo.Meal;
import com.ecust.appv1boatbackend.model.dto.QueryIngredientDTO;
import com.ecust.appv1boatbackend.model.pojo.Ingredient;
import com.ecust.appv1boatbackend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @PostMapping("/dish")
    public  ResponseEntity<MealInfoDTO> queryMealInfoByUserIdAndDate(
            @RequestBody QueryMealInfoRequestDTO queryMealInfoRequestDTO){
        List<Meal> modifyMeals = mealService.queryMealInfo(queryMealInfoRequestDTO.getUserid(), queryMealInfoRequestDTO.getDate());
        JSONObject jsonObject = new JSONObject();
        modifyMeals.forEach(meal -> {
            JSONObject object = JSONObject.parseObject(meal.getDishIds());
            for (String key:object.keySet()){
                jsonObject.put(key,object.get(key));
            }
        });
        MealInfoDTO mealInfoDTO = new MealInfoDTO(jsonObject.toJSONString(),queryMealInfoRequestDTO.getDate());
        return ResponseEntity.ok().body(mealInfoDTO);
    }

    @PostMapping("/ingredient")
    public ResponseEntity<Ingredient> queryIngredient(@RequestBody QueryIngredientDTO queryIngredientDTO){
        Ingredient ingredient = mealService.getIngredientByUserIdAndDate(queryIngredientDTO.getId(), queryIngredientDTO.getDate());
        return ResponseEntity.ok().body(ingredient);
    }
}
