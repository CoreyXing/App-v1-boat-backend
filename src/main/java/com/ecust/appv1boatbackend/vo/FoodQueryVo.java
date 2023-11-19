package com.ecust.appv1boatbackend.vo;

import io.swagger.annotations.ApiModelProperty;

public class FoodQueryVo {
    @ApiModelProperty("食品id")
    private Integer id;
    @ApiModelProperty("食品第一种类")
    private String firstClass;
    @ApiModelProperty("食品第二种类")
    private String secondClass;
    @ApiModelProperty("食品名称")
    private String foodName;
    @ApiModelProperty("食品基本营养")
    private String jibenyingyang;
    @ApiModelProperty("食品功效")
    private String gongxiao;
    @ApiModelProperty("食品酯类")
    private String zhilei;
    @ApiModelProperty("食品矿物质")
    private String kuangwuzhi;
    @ApiModelProperty("食品维生素")
    private String weishengsu;
}
