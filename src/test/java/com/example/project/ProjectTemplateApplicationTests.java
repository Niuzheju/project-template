package com.example.project;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProjectTemplateApplicationTests {

    @Setter(onMethod_ = @Autowired)
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        System.out.println(restTemplate);
    }

}
