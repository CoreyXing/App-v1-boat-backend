package com.ecust.appv1boatbackend.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实物实体类
 */
@Data
@TableName("foods")

public class Food {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String firstClass;
    private String secondClass;
    private String foodName;
    private String jibenyingyang;
    private String gongxiao;
    private String zhilei;
    private String kuangwuzhi;
    private String weishengsu;

}
