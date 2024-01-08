package com.ecust.appv1boatbackend.Repository.impl;


import com.ecust.appv1boatbackend.Repository.DishRepository;
import com.ecust.appv1boatbackend.model.pojo.Dish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    private final JdbcTemplate jdbcTemplate;

    public DishRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dish> getDishByCode(String code) {
        String sql = "SELECT * FROM dishes WHERE code =?";
        return jdbcTemplate.query(sql, new DishRowMapper(), code);
    }

    public Dish getDishById(String id) {
        String sql = "SELECT * FROM dishes WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new DishRowMapper(), id);
    }

    public List<Dish> getDishByKeyWords(String key) {
        String sql = "SELECT * FROM dishes WHERE name LIKE ?";
        return jdbcTemplate.query(sql, new DishRowMapper(), "%" + key + "%");
    }

    private static class DishRowMapper implements RowMapper<Dish> {
        @Override
        public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dish meal = new Dish();
            meal.setFoodId(rs.getString("id"));
            meal.setCode(rs.getString("code"));
            meal.setName(rs.getString("name"));
            meal.setMainUnit(rs.getString("main_unit"));
            meal.setVitaminUnit(rs.getString("vitamin_unit"));
            meal.setMineralsUnit(rs.getString("minerals_unit"));
            meal.setOtherUnit(rs.getString("other_unit"));
            meal.setMainIngredient(rs.getString("main_ingredient"));
            meal.setVitaminIngredient(rs.getString("vitamin_ingredient"));
            meal.setMineralsIngredient(rs.getString("minerals_ingredient"));
            meal.setOtherIngredient(rs.getString("other_ingredient"));
            meal.setGlycemicSection(rs.getString("glycemic_section"));
            return meal;
        }
    }
}
