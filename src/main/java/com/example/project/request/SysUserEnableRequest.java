package com.example.project.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserEnableRequest extends BaseUpdateRequest{

    private Long userId;

    @NotNull(message = "启用/禁用不能为空")
    private Boolean enabled;

}
