package com.example.project.common.spring;

import com.example.project.common.response.CommonErrorEnum;
import com.example.project.common.response.ResponseCode;
import com.example.project.common.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SuppressWarnings("rawtypes")
@ConditionalOnClass(DuplicateKeyException.class)
@RestControllerAdvice
public class DuplicateKeyExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DuplicateKeyExceptionHandler.class);

    @ExceptionHandler({DuplicateKeyException.class})
    public Result duplicateKeyException(DuplicateKeyException e) {
        logger.error("", e);
        return Result.fail(ResponseCode.CLIENT_USER_ERROR, CommonErrorEnum.DUPLICATE_KEY_ERROR);
    }
}
