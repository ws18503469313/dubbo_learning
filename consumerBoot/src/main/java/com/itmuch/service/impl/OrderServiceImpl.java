package com.itmuch.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cloud.model.UserAddress;
import com.cloud.service.OrderService;
import com.cloud.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    @Reference//dubbo 的形式
    UserAddressService userAddressService;
    @Override
    public List<UserAddress> initOrder(String s) {
        return userAddressService.getUserAddressList(s);
    }
}
