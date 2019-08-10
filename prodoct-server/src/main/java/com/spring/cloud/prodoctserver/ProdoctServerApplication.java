package com.spring.cloud.prodoctserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient //nacos 发现服务标签
public class ProdoctServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdoctServerApplication.class, args);
    }

}
