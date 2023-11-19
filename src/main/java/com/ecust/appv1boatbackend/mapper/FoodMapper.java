package com.ecust.appv1boatbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.vo.FoodQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FoodMapper extends BaseMapper<Food> {
    @Select("select * from foods where id = #{id}")
    FoodQueryVo getFoodById(@Param("id") int id);
    @Select("SELECT * From foods")
    List<FoodQueryVo> getAllFood();
}
