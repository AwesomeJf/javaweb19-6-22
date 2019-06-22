package com.wzu.qunawan.config;


import com.wzu.qunawan.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.config.annotation.*;




@Configuration

public class MyConfig implements WebMvcConfigurer{

    @Autowired
    LoginInterceptor loginInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/information.html").setViewName("information");
        registry.addViewController("/detail").setViewName("trip_detail");
    }
    /*//拦截器
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").
                excludePathPatterns( "/login.html","/","/js/**","/image/**",
                        "/css/**","/code","/login","/image_cache","/PC","/layui","/register");
    }

}
