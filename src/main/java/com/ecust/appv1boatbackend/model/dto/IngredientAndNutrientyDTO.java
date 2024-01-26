package com.ecust.appv1boatbackend.model.dto;

import com.ecust.appv1boatbackend.model.pojo.Ingredient;
import com.ecust.appv1boatbackend.model.pojo.NutrientValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientAndNutrientyDTO {

    private Ingredient ingredient;

    private NutrientValues nutrientValues;

}
