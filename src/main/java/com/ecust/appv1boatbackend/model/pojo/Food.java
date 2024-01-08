package com.ecust.appv1boatbackend.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食物实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    private String id;
    private String firstClass;
    private String secondClass;
    private String foodName;
    private String jibenyingyang;
    private String gongxiao;
    private String zhilei;
    private String kuangwuzhi;
    private String weishengsu;

}
