package com.qunar.fresh2018.spring;


import com.qunar.fresh2018.spring.support.interceptor.IpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration public class MvcConfigurer extends WebMvcConfigurerAdapter {

    @Override public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new IpInterceptor());
    }
}