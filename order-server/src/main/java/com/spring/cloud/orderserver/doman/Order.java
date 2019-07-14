package com.spring.cloud.orderserver.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author AGbetrayal
 * @date 2019/6/22 10:56
 */
@Data@AllArgsConstructor@NoArgsConstructor
public class Order implements Serializable {
    private String orderNo;
    private Date createTime;
    private String productPrice;
    private Long userId;
}
