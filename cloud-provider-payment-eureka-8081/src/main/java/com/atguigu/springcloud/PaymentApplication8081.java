package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-13-55
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8081.class,args);
    }
}
