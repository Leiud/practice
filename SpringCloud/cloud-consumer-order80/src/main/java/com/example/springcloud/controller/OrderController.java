package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class OrderController {

    // url 暂时写死，后面会改
    // public static final String PAYMENT_URL = "http://localhost:8001";

    /**
     * 通过在 Eureka 上注册过的微服务名称调用
     * 重点是这里，改成 提供者在 Eureka 上的名称，而且无需写端口号
     * 取决于我们在提供者出配置的 name: cloud-payment-service，
     * 同时要注意使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡能力
     */
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ILoadBalancer iLoadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 因为浏览器只支持 get 请求，为了方便这里就用 get
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        log.info("插入的数据：" + payment);

        /**
         * postForObject 分别有三个参数：
         * 请求地址，请求参数，返回的对象类型
         */
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        log.info("查询的 id：" + id);

        /**
         * getForObject 两个参数：
         * 请求地址，返回的对象类型
         */
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id){
        log.info("查询的 id：" + id);
        // getForObject 两个参数：请求地址，返回的对象类型
        // return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        // getStatusCode 获取状态码，is2xxSuccessful 如果是状态码是 2xx
        if(entity.getStatusCode().is2xxSuccessful()){
            // 返回 body
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/createEntity")
    public CommonResult<Payment> createEntity(Payment payment){
        log.info("插入的数据：" + payment);
        // postForObject 分别有三个参数：请求地址，请求参数，返回的对象类型
        // return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        //获取CLOUD-PAYMENT-SERVICE服务的所有具体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = iLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri);

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }
}
