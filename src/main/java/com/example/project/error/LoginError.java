package com.example.project.error;


import com.example.project.common.response.ResultError;

public enum LoginError implements ResultError {
    SMS_SEND_ERROR("SMS_SEND_ERROR", "短信发送失败"),
    USER_VERIFY_CODE_ERROR("USER_VERIFY_CODE_ERROR", "验证码输入错误"),

    NO_TOKEN_ERROR("NO_TOKEN_ERROR", "没有凭证"),
    TOKEN_ERROR("TOKEN_ERROR", "凭证无效"),
    TOKEN_EXPIRE_ERROR("TOKEN_EXPIRE_ERROR", "凭证过期，请重新登录"),
    USERNAME_OR_PASSWORD_ERROR("USERNAME_OR_PASSWORD_ERROR", "用户名或密码错误"),
    USER_EXISTS_ERROR("USER_EXISTS_ERROR", "用户已存在"),
    USER_STATUS_DISABLED_ERROR("USER_STATUS_DISABLED_ERROR", "用户状态异常"),
    TOKEN_REFRESH_ERROR("TOKEN_REFRESH_ERROR", "凭证更新失败，请稍候再试"),
    PERMISSION_DENIED_ERROR("PERMISSION_DENIED_ERROR", "拒绝访问"),
    USER_UNDEFINED_ERROR("USER_UNDEFINED_ERROR", "用户信息有误"),
    ;

    private final String code;
    private final String message;

    LoginError(String code, String message) {
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
