package com.example.project.common.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({
    ConstraintViolationExceptionHandler.class,
    DuplicateKeyExceptionHandler.class,
    ControllerExceptionHandler.class,
    ResultHandler.class,
    RestTemplateConfig.class
})
public @interface EnableIPAdvisor {
}
