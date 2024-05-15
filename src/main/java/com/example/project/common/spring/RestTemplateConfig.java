package com.example.project.common.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


@Configuration
public class RestTemplateConfig {

    /**
     *
     * @param factory 参数注入, 来自httpRequestFactory()方法返回对象
     * @return 自定义RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }


    /**
     * 创建HttpComponentsClientRestfulHttpRequestFactory并设置超时时间
     * @return 自定义ClientHttpRequestFactory
     */
    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        HttpComponentsClientRestfulHttpRequestFactory factory = new HttpComponentsClientRestfulHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofSeconds(5));
        factory.setConnectionRequestTimeout(Duration.ofSeconds(5));
        return factory;
    }

}
