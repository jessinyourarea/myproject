package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sist.web.manager","com.sist.web.controller","com.sist.web.dao"})
@SpringBootApplication
public class MySpringBootReactProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootReactProjectApplication.class, args);
    }

}
