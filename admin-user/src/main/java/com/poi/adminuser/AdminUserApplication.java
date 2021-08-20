package com.poi.adminuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.poi.mapper")
public class AdminUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminUserApplication.class, args);
    }

}
