package com.spring.cloud.ssoserver.service.impl;

import com.spring.cloud.ssoserver.emtry.User;
import com.spring.cloud.ssoserver.repository.UserRepository;
import com.spring.cloud.ssoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/7/16 9:25
 */
@Service
public class UserServiceImpl  implements UserService , UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(byUsername.getUsername(),
                byUsername.getPassword(), authorities);
    }
}
