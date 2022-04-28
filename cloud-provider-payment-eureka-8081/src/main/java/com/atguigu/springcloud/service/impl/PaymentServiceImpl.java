package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-36-11
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int insertPay(Payment payment) {
        return paymentDao.insertPay(payment);
    }

    @Override
    public Payment selectPay(Long id) {
        return paymentDao.selectPay(id);
    }
}
