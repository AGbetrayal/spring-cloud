package com.spring.cloud.ssoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AGbetrayal
 * @date 2019/7/16 10:36
 */
@Controller
public class IndexController {

    //登录
    @RequestMapping(path = {"login.ftl"})
    public String login(){
        return "login";
    }



}
