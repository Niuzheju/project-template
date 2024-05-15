package com.example.project.common.spring;

import com.example.project.common.exception.RestException;
import com.example.project.common.response.CommonErrorEnum;
import com.example.project.common.response.ResponseCode;
import com.example.project.common.response.Result;
import com.example.project.common.response.ResultErrorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

@SuppressWarnings("rawtypes")
@RestControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        logger.error("", e);
        ResultErrorImpl error = new ResultErrorImpl();
        error.setCode(e.getName());
        error.setMessage("参数不合法");
        return Result.fail(ResponseCode.CLIENT_USER_ERROR, error);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("请求参数异常， 参数：{}， 错误信息：{}", Objects.requireNonNull(e.getBindingResult().getFieldError()).getField(), e.getBindingResult().getFieldError().getDefaultMessage(), e);
        ResultErrorImpl error = new ResultErrorImpl();

        String field = e.getBindingResult().getFieldError().getField();
        if (StringUtils.hasText(field) && field.indexOf(".") > 0) {
            field = field.substring(field.lastIndexOf(".") + 1);
        }

        error.setCode(field);
        error.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return Result.fail(ResponseCode.CLIENT_USER_ERROR, error);
    }

    @ExceptionHandler({RestException.class})
    public Result restException(RestException e) {
        logger.error("", e);
        return Result.fail(e.getCode(), e.getError());
    }

    @ExceptionHandler({RuntimeException.class})
    public Result runtimeException(RuntimeException e) {
        logger.error("", e);
        return Result.fail(ResponseCode.SERVER_ERROR, CommonErrorEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public Result notFoundException(Exception e) {
        logger.error("", e);
        return Result.fail(ResponseCode.CLIENT_DEVELOPER_ERROR, CommonErrorEnum.NOT_FOUNT_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public Result unknownException(Exception e) {
        logger.error("", e);
        return Result.fail(ResponseCode.SERVER_ERROR, CommonErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
