package com.qunar.fresh2018.spring.support.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j @Component public class IpInterceptor extends HandlerInterceptorAdapter {
    @Override public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                       Object o) throws Exception {

        //        String ip = httpServletRequest.getHeader("Proxy-Client-IP");
        //        if (!Strings.isNullOrEmpty(ip)) {
        //            log.info("proxy client ip:{}", ip);
        //        }
        String ip = httpServletRequest.getRemoteAddr();
        log.info("------拦截到请求-------");
        log.info("request ip:{}", ip);
        return true;

    }

}