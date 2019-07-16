package com.spring.cloud.ssoserver.repository;

import com.spring.cloud.ssoserver.emtry.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AGbetrayal
 * @date 2019/7/16 9:04
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

}
