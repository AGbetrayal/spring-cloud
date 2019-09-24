package com.spring.cloud.ssoserver.service;

import com.spring.cloud.ssoserver.emtry.User;

/**
 * @author AGbetrayal
 * @date 2019/7/15 17:59
 */
public interface UserService {

    User findByName(String name);
}
