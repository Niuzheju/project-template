package com.example.project.common.spring;

import com.example.project.common.response.ResponseCode;
import com.example.project.common.response.Result;
import com.example.project.common.response.ResultErrorImpl;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
@ConditionalOnClass(ConstraintViolationException.class)
@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);

    @ExceptionHandler({ConstraintViolationException.class})
    public Result constraintViolationException(ConstraintViolationException e) {
        logger.error("", e);

        ResultErrorImpl error = new ResultErrorImpl();

        List<String> codeList  = new ArrayList<>();
        List<String> messageList = new ArrayList<>();

        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            String path = constraintViolation.getPropertyPath().toString();
            codeList.add(path.substring(path.lastIndexOf(".") + 1));
            messageList.add(constraintViolation.getMessage());
        }

        String codes = StringUtils.join(codeList, ',');
        String messages = StringUtils.join(messageList, ',');

        error.setCode(codes);
        error.setMessage(messages);
        return Result.fail(ResponseCode.CLIENT_USER_ERROR, error);
    }
}
