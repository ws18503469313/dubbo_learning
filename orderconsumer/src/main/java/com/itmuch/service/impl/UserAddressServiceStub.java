package com.itmuch.service.impl;

import com.cloud.model.UserAddress;
import com.cloud.service.UserAddressService;

import java.util.List;

public class UserAddressServiceStub implements UserAddressService {

    private UserAddressService userAddressService;
    /**
     * 传入的是dubbo的远程代理对象
     * @author polunzi
     * @Date: 2019/12/4
     */
    public UserAddressServiceStub(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    public List<UserAddress> getUserAddressList(String s) {
        System.out.println("hello local stub " + s);
        return userAddressService.getUserAddressList(s);
    }
}
