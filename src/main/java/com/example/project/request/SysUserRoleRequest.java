package com.example.project.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SysUserRoleRequest extends BaseUpdateRequest {

    private Long userId;
    private List<Long> roleIds;
}
