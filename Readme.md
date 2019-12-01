<!-- xml 形式 -->
1.将服务注册到注册中心

	1.)导入dubbo依赖, 操作zookeeper的客户端(curator)
	 <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>dubbo</artifactId>
        <version>2.6.2</version>
    </dependency>

    <dependency>
        <groupId>org.apache.curator</groupId>
        <artifactId>curator-framework</artifactId>
        <version>2.12.0</version>
    </dependency>

    2.)配置服务提供者
    	provider

        <?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		       xmlns:dubbo="http://dubbo.apache.org/schema/dubbo"
		       xmlns="http://www.springframework.org/schema/beans"
		       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		       http://dubbo.apache.org/schema/dubbo http://dubbo.apache.org/schema/dubbo/dubbo.xsd">

		    <!-- provider's application name, used for tracing dependency relationship -->
		    <dubbo:application name="useradderss-provider"/>
		    <!-- use multicast registry center to export service -->
		    <dubbo:registry address="zookeeper://127.0.0.1:2181"/>

		    <!-- use dubbo protocol to export service on port 20880 -->
		    <dubbo:protocol name="dubbo" port="20880"/>
		    <!-- service implementation, as same as regular local bean -->
		    <bean id="userAddressService" class="com.itmuch.service.impl.UserAddressServiceImpl"/>
		    <!-- declare the service interface to be exported -->
		    <dubbo:service interface="com.cloud.service.UserAddressService" ref="userAddressService"/>

		    <dubbo:monitor protocol="registry" />
		</beans>
		consumer
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		       xmlns:dubbo="http://dubbo.apache.org/schema/dubbo"
		       xmlns="http://www.springframework.org/schema/beans"
		       xmlns:context="http://www.springframework.org/schema/context"
		       xsi:schemaLocation=" http://www.springframework.org/schema/beans
		                            http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		                            http://dubbo.apache.org/schema/dubbo
		                            http://dubbo.apache.org/schema/dubbo/dubbo.xsd
		                            http://www.springframework.org/schema/context
		                            http://www.springframework.org/schema/context/spring-context-3.0.xsd">

		    <context:component-scan base-package="com"/>
		    <!-- consumer's application name, used for tracing dependency relationship (not a matching criterion),
		    don't set it same as provider -->
		    <dubbo:application name="oder-service"/>
		    <!-- use multicast registry center to discover service -->
		    <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
		    <!-- generate proxy for the remote service, then demoService can be used in the same way as the
		    local regular interface -->
		    <dubbo:reference id="userService" check="false" interface="com.cloud.service.UserAddressService"/>
		    <!-- 监控 -->
		    <dubbo:monitor protocol="registry" />
			<!--    <dubbo:monitor address="127.0.0.1:7070" />-->
			</beans>
			
			
<!-- springboot 形式 -->
		<!-- Apache Dubbo  -->
	    <dependency>
	        <groupId>com.alibaba.boot</groupId>
	        <artifactId>dubbo-spring-boot-starter</artifactId>
	        <version>0.2.0</version>
	    </dependency>

	    @EnableDubbo

	    server.port=80

		dubbo.application.name=order-service

		dubbo.registry.address=127.0.0.1:2181
		dubbo.registry.protocol=zookeeper


		dubbo.monitor.protocol=registry




		dubble配置的生效顺序:
			1).精确级优先(方法级优先,接口次之,全局配置再次之)
			2).消费者优先(如果级别一样,则消费者优先,提供方次之)
			3).启动参数 >  application.properties(.xml) > dubbo.propertis

