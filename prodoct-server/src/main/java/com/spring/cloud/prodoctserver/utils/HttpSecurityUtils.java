package com.spring.cloud.prodoctserver.utils;

import io.xls.commons.utils.ArrayUtils;
import io.xls.commons.utils.CollectionUtils;
import io.xls.core.authentication.api.PermitMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.Iterator;
import java.util.Set;

/**
 * @author AGbetrayal
 * @date 2019/8/1 9:50
 */
public abstract class HttpSecurityUtils {
    public HttpSecurityUtils() {
    }

    public static void buildPermitMatchers(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry, Set<Object> permitAllMatchers) {
        if (CollectionUtils.isNotEmpty(permitAllMatchers)) {
            Iterator var2 = permitAllMatchers.iterator();

            while(var2.hasNext()) {
                PermitMatcher permitMatcher = (PermitMatcher)var2.next();
                if (ArrayUtils.isNotEmpty(permitMatcher.getPermissions())) {
                    ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)urlRegistry.antMatchers(permitMatcher.getMethod(), permitMatcher.getUris())).hasAnyAuthority(permitMatcher.getPermissions());
                } else if (ArrayUtils.isNotEmpty(permitMatcher.getRoles())) {
                    ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)urlRegistry.antMatchers(permitMatcher.getMethod(), permitMatcher.getUris())).hasAnyRole(permitMatcher.getRoles());
                } else {
                    ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)urlRegistry.antMatchers(permitMatcher.getMethod(), permitMatcher.getUris())).permitAll();
                }
            }
        }

    }
}
