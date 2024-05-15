package com.example.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class TokenConfiguration implements WebMvcConfigurer {

    @Bean
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    private final static String[] PATTERNS = {
            "/login/sms",
            "/login/code/*",
            "/egg/page",
            "/notification/*",
            "/activity/*",
            "/activity/forecast/page",
            "/activity/credit/*",
            "/survey/*",
            "/copyright/page",
            "/payment/notify/alipay",
            "/payment/notify/wechat",
            "/product/*"
    };

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")//需要拦截的路径
                .excludePathPatterns(PATTERNS);//不需要拦截的路径
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
