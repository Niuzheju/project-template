package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysRolePermissionEntity {

    private Long id;
    private Long roleId;
    private String permissionKey;
    private String crtUsername;
    private Date crtTime;


}
