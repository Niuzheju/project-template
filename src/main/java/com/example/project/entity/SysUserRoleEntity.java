package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysUserRoleEntity {

    private Long id;
    private Long userId;
    private Long roleId;
    private String crtUsername;
    private Date crtTime;

}
