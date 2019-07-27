package com.spring.cloud.ssoserver.config;

import com.spring.cloud.ssoserver.config.sms.config.SmsAuthenticationSecurityConfig;
import com.spring.cloud.ssoserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * @author AGbetrayal
 * @date 2019/7/16 9:30
 */
@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceImpl userServiceImp;
    @Autowired(required = false)
    SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;

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
                .requestMatcher(new RequestMatcher() {

                    private TokenExtractor extractor = new BearerTokenExtractor();

                    @Override
                    public boolean matches(HttpServletRequest request) {
                        return extractor.extract(request) == null;
                    }
                })
                .authorizeRequests()
                .antMatchers("/oauth/*", "/login.ftl"/*, "/authentication/mobile"  这个可以不要*/).permitAll()
                .antMatchers("/test/*").hasRole("USER")
                .anyRequest()/*.fullyAuthenticated()*/
                .authenticated()
                .and()
                .apply(smsAuthenticationSecurityConfig)
        ;
    }


    /*
     * 忽略一些js请求
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/img/**", "**.jpg", "*.js", "/favicon.ico");
    }


}
