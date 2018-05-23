package com.luckdraw.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luckdraw.demo.mapper")
public class LuckDrawApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckDrawApplication.class, args);
    }
}
