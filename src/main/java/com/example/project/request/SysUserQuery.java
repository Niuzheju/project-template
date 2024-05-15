package com.example.project.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserQuery extends PageRequest {

    private String mobile;
    private String username;

}
