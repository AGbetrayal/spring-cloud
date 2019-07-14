package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrixDashboard //可视化界面
@EnableDiscoveryClient //nacos 发现服务标签
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);

    }

    /*
    * 通过网络获取远程上的信息
    * @LoadBalanced 这个标签的作用是实现负载均衡的第一步
    * */
    /*@Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
*/
}
