package com.itmuch;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableDubbo
public class ConsumerBootApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootApp.class, args);
    }
}
