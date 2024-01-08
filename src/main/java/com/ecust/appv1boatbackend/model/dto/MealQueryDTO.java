package com.ecust.appv1boatbackend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealQueryDTO {

    private String userId;

    private String date;
}
