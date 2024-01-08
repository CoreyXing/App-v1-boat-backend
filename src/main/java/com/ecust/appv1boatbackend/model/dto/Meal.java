package com.ecust.appv1boatbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    private String id;

    private String dishIds;

    private String date;

    private String userId;
}
