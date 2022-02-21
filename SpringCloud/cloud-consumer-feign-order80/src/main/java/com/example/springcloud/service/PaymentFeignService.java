package com.example.springcloud.service;

import com.example.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author echo
 * @date 2021年 12月 20日 16:04
 *
 * @Component 别忘了添加
 * Feign 封装了 Ribbon 和 RestTemplate，实现负载均衡和发送请求
 * @FeignClient(value = "CLOUD-PAYMENT-SERVICE") 作为 Feign 的接口，找 CLOUD-PAYMENT-SERVICE 服务
 * CLOUD-PAYMENT-SERVICE 服务名称，要和eureka上面的一致才行
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 这个就是 provider 的 controller 层的方法定义
     * 直接复制 8001 的方法
     * @GetMapping("/payment/get/{id}") 哪个地址
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    /*
    在提供端有：
	@GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult(200,"查询成功,serverPort:  "+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }
    */

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

}
