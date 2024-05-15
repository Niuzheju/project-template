package com.example.project.common.response;


public interface ResponseCode {
    /**
     * 服务端成功返回，且执行成功
     */
    int SUCCESS = 0;

    /**
     * 客户端错误
     * 用户输入错误，消息可直接展示给用户
     */
    int CLIENT_USER_ERROR = 10;

    /**
     * 客户端错误
     * 开发人员传参错误
     */
    int CLIENT_DEVELOPER_ERROR = 11;

    /**
     * 客户端错误
     * 开发人员需要单独处理
     */
    int CLIENT_SPECIAL_ERROR = 12;

    /**
     * access_token不合法
     */
    int ACCESS_TOKEN_INVALID_ERROR = 20;

    /**
     * access_token过期
     **/
    int ACCESS_TOKEN_EXPIRED_ERROR = 21;

    /**
     * access_token不存在
     */
    int ACCESS_TOKEN_NOT_EXIST_ERROR = 22;

    /**
     * refresh_token不合法
     */
    int REFRESH_TOKEN_INVALID_ERROR = 30;

    /**
     * refresh_token过期
     */
    int REFRESH_TOKEN_EXPIRED_ERROR = 31;

    /**
     * refresh_token不存在
     */
    int REFRESH_TOKEN_NOT_EXIST_ERROR = 32;

    /**
     * 账号问题
     * 账号过期或者被管理员禁用
     */
    int ACCOUNT_RELATED_ERROR = 40;

    /**
     * 服务端错误
     */
    int SERVER_ERROR = 50;
}
