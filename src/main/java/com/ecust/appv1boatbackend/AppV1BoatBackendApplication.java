package com.ecust.appv1boatbackend;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ecust.*.mapper")
@SpringBootApplication
public class AppV1BoatBackendApplication {

    public static void main(String[] args) {SpringApplication.run(AppV1BoatBackendApplication.class, args);
    }

}
