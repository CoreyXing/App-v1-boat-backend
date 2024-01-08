package com.ecust.appv1boatbackend.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.appv1boatbackend.Repository.DishRepository;
import com.ecust.appv1boatbackend.Repository.MealRepository;
import com.ecust.appv1boatbackend.model.dto.Meal;
import com.ecust.appv1boatbackend.model.pojo.Ingredient;
import com.ecust.appv1boatbackend.service.MealService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public void receiveMeal(Meal meal) {
        String id = meal.getId();
        String userId = meal.getUserId();
        String dishStr = meal.getDishIds();
        String date = meal.getDate();
        mealRepository.insertMeal(id, userId, dishStr, date);
    }

    @Override
    public Ingredient getIngredientByUserIdAndDate(String userId, String date) {
        List<Meal> meals = mealRepository.queryMealByUserIdAndDate(userId, date);
        List<Ingredient> ingredientsAllMealOneDay = new ArrayList<>();
        meals.forEach(meal -> {
            ingredientsAllMealOneDay.addAll(processMeal(meal));
        });
        Ingredient ingredientnSum = new
                Ingredient("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
        ingredientsAllMealOneDay.forEach(ingredient -> {
            ingredientnSum.setCalories(sumStringUseNumberAlgorithm(ingredient.getCalories(), ingredientnSum.getCalories()));
            ingredientnSum.setProtein(sumStringUseNumberAlgorithm(ingredient.getProtein(), ingredientnSum.getProtein()));
            ingredientnSum.setFat(sumStringUseNumberAlgorithm(ingredient.getFat(), ingredientnSum.getFat()));
            ingredientnSum.setDha(sumStringUseNumberAlgorithm(ingredient.getDha(), ingredientnSum.getDha()));
            ingredientnSum.setSaturatedFat(sumStringUseNumberAlgorithm(ingredient.getSaturatedFat(), ingredientnSum.getSaturatedFat()));
            ingredientnSum.setTransFat(sumStringUseNumberAlgorithm(ingredient.getTransFat(), ingredientnSum.getTransFat()));
            ingredientnSum.setMonounsaturatedFat(sumStringUseNumberAlgorithm(ingredient.getMonounsaturatedFat(), ingredientnSum.getMonounsaturatedFat()));
            ingredientnSum.setPolyunsaturatedFat(sumStringUseNumberAlgorithm(ingredient.getPolyunsaturatedFat(), ingredientnSum.getPolyunsaturatedFat()));
            ingredientnSum.setCholesterol(sumStringUseNumberAlgorithm(ingredient.getCholesterol(), ingredientnSum.getCholesterol()));
            ingredientnSum.setCarbohydrates(sumStringUseNumberAlgorithm(ingredient.getCarbohydrates(), ingredientnSum.getCarbohydrates()));
            ingredientnSum.setSugar(sumStringUseNumberAlgorithm(ingredient.getSugar(), ingredientnSum.getSugar()));
            ingredientnSum.setDietaryFiber(sumStringUseNumberAlgorithm(ingredient.getDietaryFiber(), ingredientnSum.getDietaryFiber()));
            ingredientnSum.setSodium(sumStringUseNumberAlgorithm(ingredient.getSodium(), ingredientnSum.getSodium()));
            ingredientnSum.setAlcoholContent(sumStringUseNumberAlgorithm(ingredient.getAlcoholContent(), ingredientnSum.getAlcoholContent()));
            ingredientnSum.setPurine(sumStringUseNumberAlgorithm(ingredient.getPurine(), ingredientnSum.getPurine()));
            ingredientnSum.setAsh(sumStringUseNumberAlgorithm(ingredient.getAsh(), ingredientnSum.getAsh()));
        });
        return ingredientnSum;
    }

    private String sumStringUseNumberAlgorithm(String var1, String var2) {
        double value1 = Strings.isNullOrEmpty(var1) ? 0.0 : Double.parseDouble(var1);
        double decimalResult = value1 + Double.parseDouble(var2);
        String decimalResultAsString = String.valueOf(decimalResult);
        return decimalResultAsString;
    }

    private List<Ingredient> processMeal(Meal meal) {
        List<Ingredient> ingredients = new ArrayList<>();
        String jsonStr = meal.getDishIds();
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        for (String key : jsonObject.keySet()) {
            String mainIngredient = dishRepository.getDishById(key).getMainIngredient();
            Ingredient ingredient = JSONObject.parseObject(mainIngredient, Ingredient.class);
            Integer num = jsonObject.getInteger(key);
            for (int i = 0; i < num; i++) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }
}
