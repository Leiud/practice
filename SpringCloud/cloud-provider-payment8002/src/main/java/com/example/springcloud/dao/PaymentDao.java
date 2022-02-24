package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Mapper  是 ibatis 下面的注解，@Repositoty 有时候会有问题
 */
@Mapper
public interface PaymentDao {

    /**
     * 增
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 改
     * 加上 @Param 注解，mapper 中就可以采用 #{} 的方式把 @Param 注解括号内的参数进行引用
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

    // 这里用增和改进行演示，有兴趣的可以自己加其他的方法
}
