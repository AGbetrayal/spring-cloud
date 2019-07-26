package com.spring.cloud.ssoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*
    * 测试接口
    * */
    @RequestMapping(path = {"/test/{num}"})
    @ResponseBody
    public String test(@PathVariable String num){
        return num;
    }

    /*
    * 短信登录测试接口
    * */
    @RequestMapping(path = {"/test/mobile"})
    @ResponseBody
    public String mobile(String mobile, String code){

        return "";
    }
}
