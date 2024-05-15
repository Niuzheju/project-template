package com.example.project.authorization;


public class Const {
    /** token **/
    public static final String AUTH = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    /** JWT **/
    public static final String JWT_TYP = "JWT";
    public static final String JWT_ALG = "HmacSHA256";
    // 用于签名的key, 长度最小32个字符
    public static final String JWT_SIGN_KEY = "projectTemplate_JuNaLhGJ4PbKtuckr";
    public static final String JWT_DEFAULT_ROLE = "USER";

    private Const() {
    }
}
