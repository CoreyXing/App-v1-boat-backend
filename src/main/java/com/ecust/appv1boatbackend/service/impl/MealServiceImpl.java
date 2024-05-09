package com.ecust.appv1boatbackend.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.appv1boatbackend.Repository.DishRepository;
import com.ecust.appv1boatbackend.Repository.MealRepository;
import com.ecust.appv1boatbackend.model.dto.IngredientAndNutrientyDTO;
import com.ecust.appv1boatbackend.model.pojo.*;
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
    public IngredientAndNutrientyDTO receiveMeal(Meal meal) {
        String id = meal.getId();
        String userId = meal.getUserId();
        List<MealDishInfo> mealDishInfos = meal.getDishIds();
        String dishIds = JSON.toJSONString(mealDishInfos);
        String date = meal.getDate();
        mealRepository.insertMeal(id, userId,dishIds , date);
        List<NutrientValues> nutrientValuesOneMeal = processMealForNutrient(meal);
        List<Ingredient> ingredientsOneMeal = processMealForIngredient(meal);
        NutrientValues values = addAllMealNutrientValues(nutrientValuesOneMeal);
        Ingredient ingredient = addAllMealIngredient(ingredientsOneMeal);
        return new IngredientAndNutrientyDTO(ingredient,values);
    }

    @Override
    public IngredientAndNutrientyDTO getIngredientAndNutrientyUserIdAndDate(String userId, String date) {
        List<Meal> meals = mealRepository.queryMealByUserIdAndDate(userId, date);
        List<Ingredient> ingredientsAllMealOneDay = new ArrayList<>();
        List<NutrientValues> nutrientValuesAllMealOneDay = new ArrayList<>();
        meals.forEach(meal -> {
            ingredientsAllMealOneDay.addAll(processMealForIngredient(meal));
            nutrientValuesAllMealOneDay.addAll(processMealForNutrient(meal));
        });
        NutrientValues nutrientValuesSum = addAllMealNutrientValues(nutrientValuesAllMealOneDay);
        Ingredient ingredientSum = addAllMealIngredient(ingredientsAllMealOneDay);
        return new IngredientAndNutrientyDTO(ingredientSum,nutrientValuesSum);
    }

    private Ingredient addAllMealIngredient(List<Ingredient> ingredientsAll){
        Ingredient ingredientnSum = new
                Ingredient("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
        ingredientsAll.forEach(ingredient -> {
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

    private NutrientValues addAllMealNutrientValues(List<NutrientValues> nutrientValuesAll){
        NutrientValues nutrientValuesSum = new NutrientValues("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        nutrientValuesAll.forEach(nutrientValues -> {
            nutrientValuesSum.setCholine(sumStringUseNumberAlgorithm(nutrientValues.getCholine(),nutrientValuesSum.getCholine()));
            nutrientValuesSum.setBiotin(sumStringUseNumberAlgorithm(nutrientValues.getBiotin(),nutrientValuesSum.getBiotin()));
            nutrientValuesSum.setFolate(sumStringUseNumberAlgorithm(nutrientValues.getFolate(),nutrientValuesSum.getFolate()));
            nutrientValuesSum.setNiacin(sumStringUseNumberAlgorithm(nutrientValues.getNiacin(),nutrientValuesSum.getNiacin()));
            nutrientValuesSum.setRetinol(sumStringUseNumberAlgorithm(nutrientValues.getBetaCarotene(),nutrientValuesSum.getRetinol()));
            nutrientValuesSum.setBetaCarotene(sumStringUseNumberAlgorithm(nutrientValues.getBetaCarotene(),nutrientValuesSum.getBetaCarotene()));
            nutrientValuesSum.setVitaminA(sumStringUseNumberAlgorithm(nutrientValues.getVitaminA(),nutrientValuesSum.getVitaminA()));
            nutrientValuesSum.setPantothenicAcid(sumStringUseNumberAlgorithm(nutrientValues.getPantothenicAcid(),nutrientValuesSum.getPantothenicAcid()));
            nutrientValuesSum.setVitaminC(sumStringUseNumberAlgorithm(nutrientValues.getVitaminC(),nutrientValuesSum.getVitaminC()));
            nutrientValuesSum.setVitaminB1(sumStringUseNumberAlgorithm(nutrientValues.getVitaminB1(),nutrientValuesSum.getVitaminB1()));
            nutrientValuesSum.setVitaminB2(sumStringUseNumberAlgorithm(nutrientValues.getVitaminB2(),nutrientValuesSum.getVitaminB2()));
            nutrientValuesSum.setVitaminB6(sumStringUseNumberAlgorithm(nutrientValues.getVitaminB6(),nutrientValuesSum.getVitaminB6()));
            nutrientValuesSum.setVitaminB12(sumStringUseNumberAlgorithm(nutrientValues.getVitaminB12(),nutrientValuesSum.getVitaminB12()));
            nutrientValuesSum.setVitaminD(sumStringUseNumberAlgorithm(nutrientValues.getVitaminD(),nutrientValuesSum.getVitaminD()));
            nutrientValuesSum.setVitaminE(sumStringUseNumberAlgorithm(nutrientValues.getVitaminK(),nutrientValuesSum.getVitaminK()));
            nutrientValuesSum.setVitaminK(sumStringUseNumberAlgorithm(nutrientValues.getVitaminE(),nutrientValuesSum.getVitaminE()));
        });
        return nutrientValuesSum;

    }

    @Override
    public List<Meal> queryMealInfo(String userId, String date) {
        //1.查询到 dish_id 根据日期和用户id
        List<Meal> meals = mealRepository.queryMealByUserIdAndDate(userId, date);
        //2.修改其中的dish_id的key，将其转换成真实的菜名
        meals.forEach(meal -> {
            meal.getDishIds().forEach(mealDishInfo -> {
                String dishName = dishRepository.getDishNameById(mealDishInfo.getDishId());
                mealDishInfo.setDishId(dishName);
            });
        });
        return meals;
    }

    private String sumStringUseNumberAlgorithm(String var1, String var2) {
        double value1 = Strings.isNullOrEmpty(var1) ? 0.0 : Double.parseDouble(var1);
        double decimalResult = value1 + Double.parseDouble(var2);
        String decimalResultAsString = String.valueOf(decimalResult);
        return decimalResultAsString;
    }

    private List<Ingredient> processMealForIngredient(Meal meal) {
        List<Ingredient> ingredients = new ArrayList<>();
        List<MealDishInfo> dishIds = meal.getDishIds();
        dishIds.forEach(dishId ->{
            Dish dish = dishRepository.getDishById(dishId.getDishId());
            String mainIngredient = dish.getMainIngredient();
            Ingredient ingredient = JSONObject.parseObject(mainIngredient, Ingredient.class);
            Integer num = Integer.parseInt(dishId.getNum());
            for(int i=0;i<num;i++){
                ingredients.add(ingredient);
            }
        });
        return ingredients;
    }

    private List<NutrientValues> processMealForNutrient(Meal meal){
        List<NutrientValues> nutrientValues = new ArrayList<>();
        List<MealDishInfo> dishIds = meal.getDishIds();
        dishIds.forEach(dishId ->{
            Dish dish = dishRepository.getDishById(dishId.getDishId());
            String vitaminIngredient = dish.getVitaminIngredient();
            NutrientValues nutrient = JSONObject.parseObject(vitaminIngredient, NutrientValues.class);
            int num = Integer.parseInt(dishId.getNum());
            for (int i = 0; i < num; i++) {
                nutrientValues.add(nutrient);
            }
        });
        return nutrientValues;
    }
}
