package com.spring.cloud.prodoctserver.config;

import io.xls.core.authentication.security.expression.AdminAccessPermissionEvaluator;
import io.xls.core.authentication.security.expression.AdminAccessSecurityExpressionRoot;
import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.Assert;

/**
 * @author AGbetrayal
 * @date 2019/8/1 9:48
 */
public class AdminAccessWebSecurityExpressionHandler extends AbstractSecurityExpressionHandler<FilterInvocation> implements SecurityExpressionHandler<FilterInvocation> {
    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private String defaultRolePrefix = "ROLE_";

    public AdminAccessWebSecurityExpressionHandler() {
        this.setPermissionEvaluator(new AdminAccessPermissionEvaluator());
    }

    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        AdminAccessSecurityExpressionRoot expressionRoot = new AdminAccessSecurityExpressionRoot(authentication);
        expressionRoot.setPermissionEvaluator(this.getPermissionEvaluator());
        expressionRoot.setTrustResolver(this.trustResolver);
        expressionRoot.setRoleHierarchy(this.getRoleHierarchy());
        expressionRoot.setDefaultRolePrefix(this.defaultRolePrefix);
        return expressionRoot;
    }

    public void setTrustResolver(AuthenticationTrustResolver trustResolver) {
        Assert.notNull(trustResolver, "trustResolver cannot be null");
        this.trustResolver = trustResolver;
    }

    public void setDefaultRolePrefix(String defaultRolePrefix) {
        this.defaultRolePrefix = defaultRolePrefix;
    }
}