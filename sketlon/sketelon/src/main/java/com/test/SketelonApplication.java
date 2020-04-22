package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.test.*.dao")
@ServletComponentScan
public class SketelonApplication {

    public static void main(String[] args) {

        SpringApplication.run(SketelonApplication.class, args);
    }

}
