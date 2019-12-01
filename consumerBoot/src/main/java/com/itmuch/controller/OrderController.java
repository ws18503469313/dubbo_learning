package com.itmuch.controller;

import com.cloud.model.UserAddress;
import com.cloud.service.OrderService;
import com.cloud.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/initOrder", produces = "application/json")
    @ResponseBody
    public List<UserAddress> getUserAdd(@RequestParam("uid") String s){

        return orderService.initOrder("1");
    }

}
