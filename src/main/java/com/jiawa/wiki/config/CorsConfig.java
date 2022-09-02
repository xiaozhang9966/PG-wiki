package com.jiawa.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//用来出来跨域问题
@Configuration
public class CorsConfig implements WebMvcConfigurer {//继承webConfigurer专门来解决跨域问题

    @Override
    public void addCorsMappings(CorsRegistry registry) {//CorsRegistry跨域资源共享登记。是spring中解决跨域的一种方式
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders(CorsConfiguration.ALL)//
                .allowedMethods(CorsConfiguration.ALL)//允许使用get post put 等等
                .allowCredentials(true) // 允许前端的携带cokkie信息
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求） 前端先发一个OPtions请求  先判断接口存在
    }

}
