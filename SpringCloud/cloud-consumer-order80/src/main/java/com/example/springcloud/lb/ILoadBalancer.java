package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalancer {

    /**
     * 传入具体实例的集合，返回选中的实例
     * @param serviceInstance
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstance);
}

