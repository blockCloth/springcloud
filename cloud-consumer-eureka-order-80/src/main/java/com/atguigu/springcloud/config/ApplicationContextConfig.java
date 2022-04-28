package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author dai
 * @create 2022-04-2022/4/8  11-08-18
 */
@Configuration
@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = CustomLoadBalancerConfiguration.class)
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
