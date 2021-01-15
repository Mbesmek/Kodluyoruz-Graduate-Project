package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={
//        "com.config",
//        "com.controller",
//        "com.entity",
//        "com.repository",
//        "com.service",
//        "com.service.impl",
//        "com.service.model",
//
//
//})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
