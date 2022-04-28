package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.Loadbalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author dai
 * @create 2022-04-2022/4/8  11-09-45
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class ConsumerController {
    //请求模板
    @Resource
    private RestTemplate restTemplate;
    //请求url
    @Value("${payment.url}")
    private String url;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Loadbalancer loadbalancer;

    @PostMapping("/")
    public CommonResult insertPay(@RequestBody Payment payment){
        return restTemplate.postForObject(url + "/system/payment/",payment,CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult selectPay(@PathVariable("id") Long id){
        return restTemplate.getForObject(url + "/system/payment/" + id, CommonResult.class);
    }

    @GetMapping("/forEntity/{id}")
    public ResponseEntity<CommonResult>  selectPayEntity(@PathVariable("id") Long id){
        return restTemplate.getForEntity(url + "/system/payment/" + id, CommonResult.class);
    }

    @GetMapping("/lb")
    public String getPaymentUrl(){

        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instanceList == null || instanceList.size() <= 0){
            return null;
        }

        ServiceInstance instance = loadbalancer.instances(instanceList);

        URI uri = instance.getUri();

        return restTemplate.getForObject(url + "/system/payment/lb/",String.class);
    }
}
