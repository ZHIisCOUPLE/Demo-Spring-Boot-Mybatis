package com.zcy.hello.springboot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.zcy.hello.springboot.mybatis.mapper")
@SpringBootApplication
public class HelloSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootMybatisApplication.class, args);
    }
}
