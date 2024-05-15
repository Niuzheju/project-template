package com.example.project.vo;

import com.example.project.bean.RoleBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class SysUserVO {

    private Long id;
    private String nickname;
    private String username;
    private String mobile;
    private String email;
    private Boolean enabled;
    private String crtUsername;
    private Date crtTime;
    private List<RoleBean> roleList;

}
