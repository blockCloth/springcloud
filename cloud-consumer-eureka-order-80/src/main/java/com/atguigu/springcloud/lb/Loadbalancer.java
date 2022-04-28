package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author dai
 * @create 2022-04-2022/4/20  17-17-18
 */
public interface Loadbalancer {
    /**
     * 获取eureka所有实例
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
