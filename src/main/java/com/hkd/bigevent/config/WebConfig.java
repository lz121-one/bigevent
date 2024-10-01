package com.hkd.bigevent.config;

import com.hkd.bigevent.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//注册拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //登录接口以及注册接口不拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login","/user/register");
    }
}
