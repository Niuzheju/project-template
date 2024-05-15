package com.example.project.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserPasswordRequest extends BaseUpdateRequest{

    private Long userId;
    private String password;


}
