package com.example.project.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommonErrorEnum implements ResultError {
    NOT_FOUNT_ERROR("NOT_FOUND", "找不到方法"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "系统繁忙，请稍后再试"),
    DUPLICATE_KEY_ERROR("DUPLICATE_KEY_ERROR", "数据重复"),
    REQUEST_PARAMETER_NOT_VALID_ERROR("REQUEST_PARAMETER_NOT_VALID_ERROR", "请求参数不合法"),
    PAGE_NUMBER_NOT_VALID_ERROR("PAGE_NUMBER_NOT_VALID_ERROR", "请求参数pageNumber不合法"),
    PAGE_SIZE_NOT_VALID_ERROR("PAGE_SIZE_NOT_VALID_ERROR", "请求参数pageSize不合法");
    private final String code;
    private final String message;

    CommonErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
