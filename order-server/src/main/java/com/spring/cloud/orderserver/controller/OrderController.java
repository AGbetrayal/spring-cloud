package com.spring.cloud.orderserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.orderserver.doman.Order;
import com.spring.cloud.orderserver.service.IOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author AGbetrayal
 * @date 2019/6/22 10:54
 */
@RestController
@RequestMapping("api/order")
public class OrderController {

//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Autowired
//    private IOrderService orderService;
//
//
//
//    @RequestMapping("save")
//    @HystrixCommand(fallbackMethod = "saveFallback")    //熔断降级处理  saveFallback 方法对应的字段要一样
//    public Order save(Long userId, Long productId, HttpServletRequest request){
//        String token = request.getHeader("token");
//        String cookie = request.getHeader("Cookie");
//
//        orderService.save(userId, productId);
//        return null;
//    }
//
//    public Order saveFallback(Long userId, Long productId, HttpServletRequest request){
//        //当下单失败后需要通知运维人员，异步通知
//        new Thread(() -> {
//            String key = "order-server";
//            //判断之前是否发送过短信
//            String val = redisTemplate.opsForValue().get(key);
//            if (StringUtils.isEmpty(val)){
//                //在redis中并没有这个key, 说明之前没有发送或者已经超过二十分钟了
//                System.out.println("发送短信：用户下单失败");
//                redisTemplate.opsForValue().set(key, "order-save-fail", 20, TimeUnit.SECONDS);
//            } else {
//                System.out.println("已经通知运维人员， 不需要重发短信");
//            }
//        }).start();
//        return new Order();
//    }
}
