package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FoodRepository {
    private final JdbcTemplate jdbcTemplate;

    public FoodRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Food> getAllFoods() {
        String sql = "SELECT * FROM foods";
        return jdbcTemplate.query(sql, new FoodRowMapper());
    }

    public Food getFoodById(int id) {
        String sql = "SELECT * FROM foods WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FoodRowMapper());
    }

    public List<Food> getFoodsByClass(String firstClass, String secondClass) {
        String sql = "SELECT * FROM foods WHERE first_class = ? AND second_class = ?";
        return jdbcTemplate.query(sql, new Object[]{firstClass, secondClass}, new FoodRowMapper());
    }

    public void createFood(Food food) {
        String sql = "INSERT INTO foods (first_class, second_class, food_name, jibenyingyang, gongxiao, zhilei, kuangwuzhi, weishengsu) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, food.getFirstClass(), food.getSecondClass(), food.getFoodName(),
                food.getJibenyingyang(), food.getGongxiao(), food.getZhilei(), food.getKuangwuzhi(), food.getWeishengsu());
    }

    public void updateFood(Food food) {
        String sql = "UPDATE foods SET first_class = ?, second_class = ?, food_name = ?, jibenyingyang = ?, " +
                "gongxiao = ?, zhilei = ?, kuangwuzhi = ?, weishengsu = ? WHERE id = ?";
        jdbcTemplate.update(sql, food.getFirstClass(), food.getSecondClass(), food.getFoodName(),
                food.getJibenyingyang(), food.getGongxiao(), food.getZhilei(), food.getKuangwuzhi(),
                food.getWeishengsu(), food.getId());
    }

    public void deleteFood(int id) {
        String sql = "DELETE FROM foods WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class FoodRowMapper implements RowMapper<Food> {
        @Override
        public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
            Food food = new Food();
            food.setId(rs.getInt("id"));
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
