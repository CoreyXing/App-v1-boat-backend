package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.Dish;
import com.ecust.appv1boatbackend.model.pojo.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DishRepository {
    private final JdbcTemplate jdbcTemplate;

    public DishRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Dish> getAllDishes() {
        String sql = "SELECT * FROM dishes";
        return jdbcTemplate.query(sql, new DishRepository.DishRowMapper());
    }






    private static class DishRowMapper implements RowMapper<Dish> {
        @Override
        public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setGlycemic_section(rs.getString("glycemic_section"));
            dish.setCode(rs.getString("code"));
            dish.setMain_unit(rs.getString("main_unit"));
            dish.setMain_ingredient(rs.getString("main_ingredient"));
            dish.setOther_unit(rs.getString("other_unit"));
            dish.setMinerals_unit(rs.getString("minerals_unit"));
            dish.setVitamin_ingredient(rs.getString("vitamin_ingredient"));
            dish.setVitamin_unit(rs.getString("vitamin_unit"));
            dish.setOther_ingredient(rs.getString("other_ingredients"));
            dish.setMinerals_unit(rs.getString("minerals_unit"));
            return dish;
        }
    }
}
