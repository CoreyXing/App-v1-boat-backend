package com.ecust.appv1boatbackend.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${mysql.authentication.firsturl}")
    private String firstUrl;

    @Value("${mysql.authentication.secondurl}")
    private String secondUrl;

    @Value("${mysql.authentication.userName}")
    private String userName;

    @Value("${mysql.authentication.password}")
    private String password;

    @Value("${mysql.authentication.driverClassName}")
    private String driverClassName;

    @Primary
    @Bean(name = "primaryDataSource")
    public DataSource firstDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(firstUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "secondaryDataSource")
    public DataSource secondDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(secondUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
