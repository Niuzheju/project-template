package com.example.project.enumeration;

public enum UserRoleEnum implements CodeEnum {

    /**
     * 超级管理员
     */
    SUPER_ADMIN(1),

    /**
     * 管理员
     */
    ADMIN(2)
   ;

    private final int code;

    UserRoleEnum(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
