package com.spring.cloud.ssoserver.config;

import com.spring.cloud.ssoserver.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author AGbetrayal
 * @date 2019/7/16 9:30
 */
@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter{

    @Autowired
    UserServiceImpl userServiceImp;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * 自定义认证规则(登录校验)
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImp).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .loginPage("/login.ftl")
                .loginProcessingUrl("/login")
                .and()
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*", "/login.ftl").permitAll()
                .antMatchers("/test/*").hasRole("USER")
                .anyRequest()/*.fullyAuthenticated()*/
                .authenticated()

//                .sessionManagement()
//                .enableSessionUrlRewriting(false)
//                .sessionAuthenticationStrategy(createSessionAuthenticationStrategy())
        ;
    }

//    @Bean
//    public CreateSessionAuthenticationStrategy createSessionAuthenticationStrategy() {
//        return new CreateSessionAuthenticationStrategy();
//    }

    /*
    * 忽略一些js请求
    * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/favicon.ico");
    }


//    @Slf4j
//    private static class CreateSessionAuthenticationStrategy implements SessionAuthenticationStrategy, ApplicationEventPublisherAware {
//
//        private ApplicationEventPublisher applicationEventPublisher;
//
//        @Override
//        public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//            this.applicationEventPublisher = applicationEventPublisher;
//        }
//
//        @Override
//        public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws SessionAuthenticationException {
//            HttpSession session = request.getSession();
//            onSessionChange(session.getId(), session, authentication);
//        }
//
//        private void onSessionChange(String originalSessionId, HttpSession newSession, Authentication auth) {
//            if (null != applicationEventPublisher) {
//                applicationEventPublisher.publishEvent(new SessionFixationProtectionEvent(auth,
//                        originalSessionId, newSession.getId()));
//            }
//        }
//    }
}
