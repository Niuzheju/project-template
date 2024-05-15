package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author niuzheju
 * @Date 14:55 2024/4/30
 */
@Setter
@Getter
public class UserEntity {

    private Long id;
    private String username;
    private String nickname;
    private String mobile;
    private String avatar;
    private Boolean enable;
    private String role;
    private Date modifyTime;
    private Date createTime;
}
