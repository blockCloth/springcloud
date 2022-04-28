package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-59-55
 */
@Mapper
public interface PaymentDao {

    int insertPay(Payment payment);

    Payment selectPay(@Param("id") Long id);
}
