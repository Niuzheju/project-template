package com.example.project;

import com.example.project.common.spring.EnableIPAdvisor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.project.mapper")
@EnableIPAdvisor
@SpringBootApplication
public class ProjectTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTemplateApplication.class, args);
    }

}
