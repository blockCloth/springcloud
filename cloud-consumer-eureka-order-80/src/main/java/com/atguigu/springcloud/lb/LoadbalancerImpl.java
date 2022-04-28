package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dai
 * @create 2022-04-2022/4/20  17-20-20
 */
@Service
public class LoadbalancerImpl implements Loadbalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("第几次请求next-->" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        //请求次数对实例个数进行取余
        int index = getAndIncrement() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
