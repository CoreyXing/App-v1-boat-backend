package com.ecust.appv1boatbackend.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetFoodByIdBO {
    @ApiModelProperty("食品id")
    private int id;
}
