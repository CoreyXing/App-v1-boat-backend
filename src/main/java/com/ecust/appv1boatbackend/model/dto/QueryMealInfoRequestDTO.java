package com.ecust.appv1boatbackend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryMealInfoRequestDTO {

    String userid;

    String date;
}
