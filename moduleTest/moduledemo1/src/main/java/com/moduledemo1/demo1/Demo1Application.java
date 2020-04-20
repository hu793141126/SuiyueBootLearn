package com.moduledemo1.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo1Application.class, args);
        Demo1Service demo1Service=new Demo1Service();
        demo1Service.demo1();
    }

}
