package com.example.project.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class SysUserResponse {

    private Long id;
    private String nickname;
    private String username;
    private String mobile;
    private Boolean enabled;
    private String crtUsername;
    private Date crtTime;
    private List<RoleResponse> roleList;

}
