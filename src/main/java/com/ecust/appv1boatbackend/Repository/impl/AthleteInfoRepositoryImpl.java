package com.ecust.appv1boatbackend.Repository.impl;

import com.ecust.appv1boatbackend.Repository.AthleteInfoRepository;
import com.ecust.appv1boatbackend.model.pojo.AthleteInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Xingweicheng
 * @description: 查询运动员身高和体重
 * @date: 2024/5/9 11:15
 */
@Repository
public class AthleteInfoRepositoryImpl implements AthleteInfoRepository {


    private final JdbcTemplate jdbcTemplate;

    public AthleteInfoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AthleteInfo getAthleteInfoBy(String id) {
        String sql = "SELECT * FROM ATHLETE_INFO WHERE id =?";
        return jdbcTemplate.queryForObject(sql,new AthleteInfoRowMapper(), id);
    }


    private static class AthleteInfoRowMapper implements RowMapper<AthleteInfo>{

        @Override
        public AthleteInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            AthleteInfo athleteInfo = new AthleteInfo();
            athleteInfo.setId(rs.getInt("id"));
            athleteInfo.setHeight(rs.getString("height"));
            athleteInfo.setWeight(rs.getString("weight"));
            return athleteInfo;
        }
    }
}
