package com.spring.cloud.ssoserver.validateCode.validateCodeEntry;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 验证码信息封装类
 * @author AGbetrayal
 * @date 2019/7/27 10:27
 */
@Data
public class ValidateCode {
    private static final long serialVersionUID = 1588203828504660915L;

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    /*
    * 判断是否有限期内
    * */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
