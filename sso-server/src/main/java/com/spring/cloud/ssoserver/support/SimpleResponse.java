package com.spring.cloud.ssoserver.support;

/**
 * 简单响应的封装类
 * @author AGbetrayal
 * @date 2019/7/27 14:23
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
