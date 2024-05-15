package com.example.project.entity;



import com.example.project.enumeration.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysUserEntity {

    private Long id;
    private String username;
    private String nickname;
    //枚举类型前面一个字段不可为null （mybatis 序列化的一个bug，枚举类前面一个字段为null，则此字段也会为null）
    private UserRoleEnum role;
    private String mobile;
    private String password;
    private Boolean enable;
    private Date modifyTime;
    private Date createTime;
    private String createUsername;
    private String modifyUsername;

}
