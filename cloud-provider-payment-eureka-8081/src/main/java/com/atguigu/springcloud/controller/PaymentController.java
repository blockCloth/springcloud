package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-44-06
 */
@RestController
@RequestMapping("/system/payment")
@Log4j2
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String servicePort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/")
    public CommonResult insertPay(@RequestBody Payment payment){
        if (paymentService.insertPay(payment) > 0){
            return CommonResult.success("添加成功！");
        }else {
            return CommonResult.error("添加失败！");
        }
    }

    @GetMapping("/{id}")
    public CommonResult selectPay(@PathVariable("id") Long id){
        Payment payment = paymentService.selectPay(id);
        if (payment != null) {
            return CommonResult.success("查询成功！,servicePort="+servicePort,payment);
        }else {
            return CommonResult.error("查询数据失败，没有对应id["+id+"]");
        }
    }

    @GetMapping("/discovery")
    public Object getDisCovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("discoveryService=>" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance=>" + instance.getServiceId() + "\t" + instance.getUri()
            + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return discoveryClient;
    }

    //返回端口号
    @GetMapping("/lb")
    public String returnPort(){
        return servicePort;
    }

    //设置OpenFeign响应时间
    @GetMapping("/timeout")
    public String sleepTime(){
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}
