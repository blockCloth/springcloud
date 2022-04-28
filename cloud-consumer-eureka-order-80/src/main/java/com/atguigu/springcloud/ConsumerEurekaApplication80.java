package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dai
 * @create 2022-04-2022/4/8  10-59-59
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerEurekaApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaApplication80.class,args);
    }
}
