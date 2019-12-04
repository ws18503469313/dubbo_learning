package com.itmuch.config;

import com.alibaba.dubbo.config.*;
import com.cloud.service.UserAddressService;
import com.google.common.collect.Lists;
import javafx.application.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class CustomerDubboConfig {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName("useradderss-provider");
        //...
        return config;
    }
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig config = new RegistryConfig();
        config.setAddress("127.0.0.1:2181");
        config.setProtocol("zookeeper");
        return config;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);

        return config;
    }

    public ServiceConfig<UserAddressService> serviceConfig(UserAddressService userAddressService){

        ServiceConfig<UserAddressService> config = new ServiceConfig<>();
        config.setInterface(UserAddressService.class);
        config.setRef(userAddressService);
        config.setTimeout(3000);
        config.setVersion("1.0.0");

        List<MethodConfig> methodConfigs = Lists.newArrayList();

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(2000);
        methodConfigs.add(methodConfig);
        //providerConfig
        //MinitConfig


        config.setMethods(methodConfigs);

        return config;
    }

}
