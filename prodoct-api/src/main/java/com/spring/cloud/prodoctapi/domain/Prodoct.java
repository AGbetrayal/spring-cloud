package com.spring.cloud.prodoctapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author AGbetrayal
 * @date 2019/6/21 21:50
 */
@Data@AllArgsConstructor@NoArgsConstructor
public class Prodoct implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private int stock;
}
