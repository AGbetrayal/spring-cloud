package com.spring.cloud.ssoserver.config;

import com.spring.cloud.ssoserver.error.MssWebResponseExceptionTranslator;
import com.spring.cloud.ssoserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/25 19:20
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    UserServiceImpl userServiceImp;

    @Autowired(required = false)
    JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;


    @Autowired
    DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证
//            clients.inMemory().withClient("client_1")
//                    .resourceIds("app")
//                    .authorizedGrantTypes("client_credentials")
//                    .scopes("select")
//                    .authorities("oauth2")
//                    .secret("123456")
//                    .and().withClient("client_2")
//                    .resourceIds("XcWebApp")
//                    .authorizedGrantTypes("password", "refresh_token")
//                    .scopes("app")
//                    .authorities("oauth2")
//                    .secret("$2a$10$9bEpZ/hWRQxyr5hn5wHUj.jxFpIrnOmBcWlE/g/0Zp3uNxt9QTh/S");
        clients.withClientDetails(clientDetails());
    }

    @Bean
    public JdbcClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }


    /*
     * 认证错误异常
     * */
    @Bean
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator() {
        return new MssWebResponseExceptionTranslator();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(redisTokenStore())
                //.tokenStore(new InMemoryTokenStore())     // token放在缓存中
                .authenticationManager(authenticationManager)
                .userDetailsService(userServiceImp)
                // 2018-4-3 增加配置，允许 GET、POST 请求获取 token，即访问端点：oauth/token
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .exceptionTranslator(webResponseExceptionTranslator());

        endpoints.reuseRefreshTokens(true);

        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList<>();
        enhancerList.add(jwtTokenEnhancer);
        enhancerList.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(enhancerList);


        if (jwtAccessTokenConverter != null) {
            endpoints
                    .tokenEnhancer(enhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }
    }


    @Bean
    public RedisTokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }


}
