package com.ecust.appv1boatbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecust.appv1boatbackend.model.pojo.Food;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodMapper extends BaseMapper<Food> {
}
