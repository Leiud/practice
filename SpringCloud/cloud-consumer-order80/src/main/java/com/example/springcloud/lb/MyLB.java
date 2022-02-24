package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author echo
 * @date 2021年 12月 15日 21:09
 *
 * @Component 加入容器
 */
@Component
public class MyLB implements ILoadBalancer {

    /**
     * 新建一个原子整形类
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            // 如果 current 是最大值，重新计算，否则加 1（防止越界）
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

            // 进行 CAS 判断，如果不为 true，进行自旋
        }while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("第几次访问，次数 next：" + next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
        // 非空判断
        if(serviceInstance.size() <= 0){
            return null;
        }
        // 进行取余
        int index = getAndIncrement() % serviceInstance.size();
        // 返回选中的服务实例
        return serviceInstance.get(index);
    }
}
