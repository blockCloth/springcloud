package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-34-51
 */
public interface PaymentService{
    int insertPay(Payment payment);

    Payment selectPay(@Param("id") Long id);
}
