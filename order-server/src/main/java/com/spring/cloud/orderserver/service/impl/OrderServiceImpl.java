package com.spring.cloud.orderserver.service.impl;

import com.spring.cloud.orderserver.doman.Order;
import com.spring.cloud.orderserver.service.IOrderService;
import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctapi.feign.ProductFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author AGbetrayal
 * @date 2019/6/22 11:03
 */
@Service
public class OrderServiceImpl implements IOrderService {

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private ProductFeignApi productFeignApi;

    @Override
    public Order save(Long userId, Long productId) {
        //实现负载均衡的第二步
        /*List prodoctList =
            restTemplate.getForObject("http://PRODUCT-SERVER/api/list"
                    , List.class);*/
        List prodoctList =productFeignApi.list();
        System.out.println(prodoctList);
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        order.setCreateTime(new Date());
        return order;
    }
}
