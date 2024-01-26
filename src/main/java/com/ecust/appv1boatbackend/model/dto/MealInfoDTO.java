package com.ecust.appv1boatbackend.model.dto;


import com.ecust.appv1boatbackend.model.pojo.MealDishInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MealInfoDTO {

    List<MealDishInfo> mealInfo;

    String date;

}
