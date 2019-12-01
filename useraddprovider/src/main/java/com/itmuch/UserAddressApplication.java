package com.itmuch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAddressApplication {


    public static void main(String args[]) throws Exception{
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();
        System.in.read();
    }
}
