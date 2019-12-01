package com.itmuch.service.impl;

import com.cloud.model.UserAddress;
import com.cloud.service.OrderService;
import com.cloud.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserAddressService userAddressService;
    public List<UserAddress> initOrder(String s) {
        List<UserAddress> userAddresses = userAddressService.getUserAddressList("1");
        System.out.println(userAddresses);
        return userAddresses;
    }
}
