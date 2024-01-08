package com.ecust.appv1boatbackend.controller;


import com.ecust.appv1boatbackend.model.dto.FuzzyQueryByNameResponseDTO;
import com.ecust.appv1boatbackend.model.pojo.Dish;
import com.ecust.appv1boatbackend.model.pojo.IngredientUnit;
import com.ecust.appv1boatbackend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/key")
    public ResponseEntity<List<Dish>> fuzzyQueryByNameReturnDishes(
            @RequestParam String key) {
        List<Dish> dishes = dishService.getDishByKeyWord(key);
        return ResponseEntity.ok(dishes);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FuzzyQueryByNameResponseDTO>> fuzzyQueryByNameReturnIdAndName(
            @RequestParam String key) {
        List<Dish> dishes = dishService.getDishByKeyWord(key);
        List<FuzzyQueryByNameResponseDTO> collect = dishes.stream().map(dish -> (new FuzzyQueryByNameResponseDTO(dish.getFoodId(), dish.getName()))).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }


    @GetMapping("/id")
    public ResponseEntity<Dish> getDishById(
            @RequestParam String id
    ) {
        Dish dish = dishService.getDishById(id);
        return ResponseEntity.ok(dish);

    }

    @GetMapping("/unit")
    public ResponseEntity<IngredientUnit> getDishMainUnitById(
            @RequestParam String id
    ) {
        IngredientUnit unit = dishService.getMainUnitById(id);
        return ResponseEntity.ok(unit);

    }


}
