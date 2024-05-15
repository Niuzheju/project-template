package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysPermissionEntity {

    private Long id;
    private String key;
    private String method;
    private String api;
    private String crtUsername;
    private Date crtTime;


}
