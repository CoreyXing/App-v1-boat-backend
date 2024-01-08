package com.ecust.appv1boatbackend.model.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {
    @JSONField(name = "热量")
    private String calories;
    @JSONField(name = "蛋白质")
    private String protein;
    @JSONField(name = "脂肪")
    private String fat;
    @JSONField(name = "-DHA")
    private String dha;
    @JSONField(name = "-饱和脂肪")
    private String saturatedFat;
    @JSONField(name = "-反式脂肪")
    private String transFat;
    @JSONField(name = "-单不饱和脂肪")
    private String monounsaturatedFat;
    @JSONField(name = "-多不饱和脂肪")
    private String polyunsaturatedFat;
    @JSONField(name = "胆固醇")
    private String cholesterol;
    @JSONField(name = "碳水化合物")
    private String carbohydrates;
    @JSONField(name = "糖")
    private String sugar;
    @JSONField(name = "膳食纤维")
    private String dietaryFiber;
    @JSONField(name = "钠")
    private String sodium;
    @JSONField(name = "酒精度")
    private String alcoholContent;
    @JSONField(name = "嘌呤")
    private String purine;
    @JSONField(name = "灰分")
    private String ash;

}
