package com.spring.cloud.ssoserver.config;

import com.spring.cloud.ssoserver.config.jwt.JwtTokenEnhancer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author AGbetrayal
 * @date 2019/7/23 14:18
 */
@Configuration
//@ConditionalOnProperty(prefix = "xxx", name = "storeType", havingValue = "jwt", matchIfMissing = true)
@EnableConfigurationProperties(value = {AuthorizationServerProperties.class})
public class TokenStoreConfig {

//    @Bean
//    public TokenStore jwtTokenStore(){
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("sakdhfnlkshaklhndlkshdlkhdf");
        return accessTokenConverter;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer(){
        return new JwtTokenEnhancer();
    }
}
