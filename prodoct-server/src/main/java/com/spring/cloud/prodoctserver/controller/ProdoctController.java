package com.spring.cloud.prodoctserver.controller;

import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctserver.service.IProdoctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/21 22:37
 */
@RestController
@RequestMapping("/api")
@RefreshScope //使配置中心的信息改了能时时有效
public class ProdoctController {

    @Autowired
    private IProdoctService prodoctService;
    @RequestMapping("list")
    public List<Prodoct> list(){
        return  prodoctService.list();
    }

//    @Value("${xx}")
//    private String xx;
    /*
     * 测试配置中心有没有起效
     * */
    @RequestMapping("xx")
    public String xx(){
        return "";
    }
}
