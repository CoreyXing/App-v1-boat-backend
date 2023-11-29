package com.ecust.appv1boatbackend.model.pojo;

import lombok.Data;

@Data
public class Dish {
    private Integer id;
    private String code;
    private String name;
    private String main_unit;
    private String vitamin_unit;
    private String minerals_unit;
    private String other_unit;
    private String main_ingredient;
    private String vitamin_ingredient;
    private String minerals_ingredient;
    private String other_ingredient;
    private String glycemic_section;

}
