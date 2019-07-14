package com.spring.cloud.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Filter;

/**
 * @author AGbetrayal
 * @date 2019/6/23 11:54
 */
@Component
public class AuthZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //是什么类型的filter
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println(request.getRequestURI());
        if ( request.getRequestURI().startsWith("order/api/vl") ){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //处理请求有带来的token
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            //处理地址栏中带来的token
            token = request.getParameter("token");
        }
        //如果经过上面两步都是没有token，说明还没登录  返回没有认证的状态码
        if (StringUtils.isEmpty(token)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
