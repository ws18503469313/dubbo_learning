package com.itmuch.service.ipml;

import com.alibaba.dubbo.config.annotation.Service;
import com.cloud.model.UserAddress;
import com.cloud.service.UserAddressService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 1.将服务注册到注册中心
 *  1.)导入dubbo依赖, 操作zookeeper的客户端(curator)
 *  2.)配置服务提供者
 * @author polunzi
 * @Date: 2019/12/1
 * @Param:
 * @return:
 */

@Service
@Component
public class UserAddressServiceImpl implements UserAddressService {

    @Override
    public List<UserAddress> getUserAddressList(String uid) {
        List<UserAddress> result = Lists.newArrayList();
        result.add(new UserAddress(1L, "user_1", "wangshuai", "18503469313", "shanxijiexiu", true));
        result.add(new UserAddress(2L, "user_1", "wangshuai", "18503469313", "neijingchangpin", false));
        return result;
    }
}
