package com.ecust.appv1boatbackend.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 菜品实体类
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String foodId;
    private String code;
    private String name;
    private String mainUnit;
    private String vitaminUnit;
    private String mineralsUnit;
    private String otherUnit;
    private String mainIngredient;
    private String vitaminIngredient;
    private String mineralsIngredient;
    private String otherIngredient;
    private String glycemicSection;
}
