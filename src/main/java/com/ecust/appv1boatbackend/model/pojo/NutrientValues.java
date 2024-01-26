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
public class NutrientValues {
    @JSONField(name = "维生素A")
    private String vitaminA;

    @JSONField(name = "胡萝卜素")
    private String betaCarotene;

    @JSONField(name = "维生素D")
    private String vitaminD;

    @JSONField(name = "维生素E")
    private String vitaminE;

    @JSONField(name = "维生素K")
    private String vitaminK;

    @JSONField(name = "维生素B1")
    private String vitaminB1;

    @JSONField(name = "维生素B2")
    private String vitaminB2;

    @JSONField(name = "维生素B6")
    private String vitaminB6;

    @JSONField(name = "维生素B12")
    private String vitaminB12;

    @JSONField(name = "维生素C")
    private String vitaminC;

    @JSONField(name = "烟酸")
    private String niacin;

    @JSONField(name = "叶酸")
    private String folate;

    @JSONField(name = "泛酸")
    private String pantothenicAcid;

    @JSONField(name = "生物素")
    private String biotin;

    @JSONField(name = "胆碱")
    private String choline;

    @JSONField(name = "视黄醇")
    private String retinol;

}
