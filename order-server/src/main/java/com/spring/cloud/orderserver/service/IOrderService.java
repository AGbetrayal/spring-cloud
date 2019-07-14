package com.spring.cloud.orderserver.service;

import com.spring.cloud.orderserver.doman.Order;

/**
 * @author AGbetrayal
 * @date 2019/6/22 11:02
 */
public interface IOrderService {
    Order save(Long userId, Long productId);

}
