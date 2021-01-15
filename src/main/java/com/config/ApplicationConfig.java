package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ={

        "com.entity",
        "com.repository",
        "com.service.impl",
        "com.service.model"

} )
public class ApplicationConfig {

}
