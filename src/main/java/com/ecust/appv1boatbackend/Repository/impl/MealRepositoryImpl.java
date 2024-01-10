package com.ecust.appv1boatbackend.Repository.impl;

import com.ecust.appv1boatbackend.Repository.MealRepository;
import com.ecust.appv1boatbackend.model.pojo.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MealRepositoryImpl implements MealRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Meal> queryMealByUserIdAndDate(String userId, String date) {
        String sql = "SELECT * FROM meals WHERE user_id = ? and date = ?";
        List<Meal> meals = jdbcTemplate.query(sql, new MealRowMapper(), userId, date);
        return meals;
    }

    public MealRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insertMeal(String id, String userId,
                           String dishesId, String date) {
        String sql = "INSERT INTO meals (id, user_id, dish_id, date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, userId, dishesId, date);
    }

    private static class MealRowMapper implements RowMapper<Meal>{
        @Override
        public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Meal meal = new Meal();
            meal.setId(rs.getString("id"));
            meal.setUserId(rs.getString("user_id"));
            meal.setDishIds(rs.getString("dish_id"));
            meal.setDate(rs.getString("date"));
            return meal;
        }
    }
}
