package com.ecust.appv1boatbackend.Repository.impl;

import com.ecust.appv1boatbackend.Repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class UserLoginRepositoryImpl implements UserLoginRepository {


    private JdbcTemplate jdbcTemplate;

    public UserLoginRepositoryImpl(@Qualifier("secondaryDataSource") DataSource dataSource) {
        this.jdbcTemplate =  new JdbcTemplate(dataSource);;
    }

    @Override
    public String queryIdWithNameAndPassword(String name, String password) {
        String sql = "SELECT id FROM user WHERE name = ? AND password = ?";
        String id = jdbcTemplate.queryForObject(sql, String.class, name, password);
        return id;
    }
}
