package com.spring.cloud.prodoctserver.controller;

import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctapi.feign.ProductFeignApi;
import com.spring.cloud.prodoctserver.service.IProdoctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/22 13:30
 */
@RestController
public class ProductFeignClient implements ProductFeignApi {

    @Autowired
    private IProdoctService prodoctService;


    @Override
    public List<Prodoct> list() {
        return  prodoctService.list();
    }
}
