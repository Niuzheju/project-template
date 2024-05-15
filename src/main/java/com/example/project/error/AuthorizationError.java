package com.example.project.error;


import com.example.project.common.response.ResultError;

public enum AuthorizationError implements ResultError {
    PERMISSION_DENIED("PERMISSION_DENIED", "访问被拒"),
    ;

    private final String code;
    private final String message;

    AuthorizationError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
