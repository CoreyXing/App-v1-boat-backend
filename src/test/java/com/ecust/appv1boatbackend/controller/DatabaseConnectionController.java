package com.ecust.appv1boatbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/test")
public class DatabaseConnectionController {

    private final DataSource dataSource;

    public DatabaseConnectionController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/connection")
    public String testDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "数据库连接成功!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "数据库连接失败";
        }
    }
}
