package com.ecust.appv1boatbackend.config;

import com.ecust.appv1boatbackend.interceptor.UserInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



//@Configuration
//public class AppConfigurer extends WebMvcConfigurationSupport {
//    @Autowired
//    private UserInfoInterceptor userInfoInterceptor;
//
//    /**
//     * 拦截器，将用户信息放入threadLocal
//     *
//     * @param registry
//     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.userInfoInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login/*");
//        super.addInterceptors(registry);
//    }
//
//}
