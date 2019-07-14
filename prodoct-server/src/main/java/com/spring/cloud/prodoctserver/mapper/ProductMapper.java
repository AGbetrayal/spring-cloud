package com.spring.cloud.prodoctserver.mapper;

import com.spring.cloud.prodoctapi.domain.Prodoct;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AGbetrayal
 * @date 2019/6/21 22:23
 */
@Component
public class ProductMapper {
    private List<Prodoct> list =new ArrayList<>();
    private Map<Long,Prodoct> map =new HashMap<>();
    public ProductMapper(){
        Prodoct p1 = new Prodoct(1L, "小米", new BigDecimal("1999"), 10);
        Prodoct p2 = new Prodoct(2L, "苹果", new BigDecimal("5999"), 10);
        Prodoct p3 = new Prodoct(3L, "华为", new BigDecimal("19999"), 10);
        map.put(p1.getId(),p1);
        map.put(p2.getId(),p2);
        map.put(p3.getId(),p3);
    }
    public  List<Prodoct> list(){
        return new ArrayList<>(map.values());
    }

}
