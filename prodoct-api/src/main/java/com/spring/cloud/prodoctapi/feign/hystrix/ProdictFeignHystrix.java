package com.spring.cloud.prodoctapi.feign.hystrix;

import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctapi.feign.ProductFeignApi;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/22 19:47
 */
@Component
public class ProdictFeignHystrix implements ProductFeignApi {
    @Override
    public List<Prodoct> list() {
        //返回默认
        return null;
    }
}
