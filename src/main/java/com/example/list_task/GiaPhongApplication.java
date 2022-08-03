package com.example.list_task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.example.list_task.mapper"})
public class GiaPhongApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiaPhongApplication.class, args);
    }

}
