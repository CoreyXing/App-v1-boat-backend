package com.ecust.appv1boatbackend.Repository.impl;

import com.ecust.appv1boatbackend.Repository.FoodRepository;
import com.ecust.appv1boatbackend.model.pojo.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FoodRepositoryImpl implements FoodRepository {
    private final JdbcTemplate jdbcTemplate;

    public FoodRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Food> getAllFoods() {
        String sql = "SELECT * FROM foods";
        return jdbcTemplate.query(sql, new FoodRowMapper());
    }

    public Food getFoodById(String id) {
        String sql = "SELECT * FROM foods WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FoodRowMapper());
    }

    public List<Food> getFoodsByClass(String firstClass, String secondClass) {
        String sql = "SELECT * FROM foods WHERE first_class = ? AND second_class = ?";
        return jdbcTemplate.query(sql, new Object[]{firstClass, secondClass}, new FoodRowMapper());
    }

    public List<Food> getFoodsByName(String name) {
        String sql = "SELECT * FROM foods WHERE food_name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new FoodRowMapper());
    }


    /**
     * 根据第一类名称获取第二类的名称
     */
    public List<String> getSecondClassByFirstClass(String firstClass) {
        String sql = "SELECT * FROM foods WHERE first_class = ?";
        List<Food> foodResultList = jdbcTemplate.query(sql, new Object[]{firstClass}, new FoodRowMapper());
        return foodResultList.stream().map(Food::getSecondClass).collect(Collectors.toList());
    }

    public List<Food> getFoodsByFirstClass(String firstClass) {
        String sql = "SELECT * FROM foods WHERE first_class = ?";
        List<Food> foodResultList = jdbcTemplate.query(sql, new Object[]{firstClass}, new FoodRowMapper());
        return foodResultList;

    }

    private static class FoodRowMapper implements RowMapper<Food> {
        @Override
        public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
            Food food = new Food();
            food.setId(rs.getString("id"));
            food.setFirstClass(rs.getString("first_class"));
            food.setSecondClass(rs.getString("second_class"));
            food.setFoodName(rs.getString("food_name"));
            food.setJibenyingyang(rs.getString("jibenyingyang"));
            food.setGongxiao(rs.getString("gongxiao"));
            food.setZhilei(rs.getString("zhilei"));
            food.setKuangwuzhi(rs.getString("kuangwuzhi"));
            food.setWeishengsu(rs.getString("weishengsu"));
            return food;
        }
    }
}
