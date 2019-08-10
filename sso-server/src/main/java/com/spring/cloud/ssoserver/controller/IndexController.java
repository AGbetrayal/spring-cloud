package com.spring.cloud.ssoserver.controller;

import com.spring.cloud.ssoserver.validateCode.validateCodeProcessorHolder.ValidateCodeProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    * 短信登录测试接口(这个没用, 写在登录逻辑哪里了)
    * */
    @RequestMapping(path = {"/test/mobile"})
    @ResponseBody
    public String mobile(String mobile, String code){

        return "";
    }

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /*
    * 验证码生成
    * */
    @RequestMapping(path = {"/code/{type}"})
    @ResponseBody
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception{
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }

    /*
    * 测试axios 前端请求
    * */
    @PostMapping("/axios/{test}")
    @ResponseBody
    public Object axios(@PathVariable String test) throws Exception{
        return test;
    }
}
