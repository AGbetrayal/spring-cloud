package com.spring.cloud.prodoctapi.feign;


import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctapi.feign.hystrix.ProdictFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/22 13:21
 */
@FeignClient(name="PRODUCT-SERVER", fallback = ProdictFeignHystrix.class)
public interface ProductFeignApi {

    @RequestMapping("list")
    List<Prodoct> list();
}
