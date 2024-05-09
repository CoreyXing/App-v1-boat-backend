package com.ecust.appv1boatbackend.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Xingweicheng
 * @description: 运动员信息
 * @date: 2024/5/9 11:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteInfo {

    private int id;

    private String height;

    private String weight;


}
