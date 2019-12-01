package com.itmuch;

import com.cloud.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.criteria.Order;

public class OrderServiceApplication {


    public static void main(String args[]) throws Exception{
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        OrderService service = ioc.getBean(OrderService.class);
        service.initOrder("1");
        System.in.read();
    }
}
