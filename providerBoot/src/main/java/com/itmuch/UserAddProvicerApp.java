package com.itmuch;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.itmuch.config.CustomerDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo//(scanBasePackageClasses = {CustomerDubboConfig.class})
public class UserAddProvicerApp {

    public static void main(String[] args) {
        SpringApplication.run(UserAddProvicerApp.class, args);
    }
}
