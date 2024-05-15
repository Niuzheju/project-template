package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysRoleEntity {

    private Long id;
    private String role;
    private String roleZH;
    private Boolean enabled;
    private String crtUsername;
    private Date crtTime;
    private String updUsername;
    private Date updTime;

}
