package com.example.project.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnableRoleRequest extends BaseUpdateRequest {

    private Long roleId;

    @NotNull(message = "请选择启用或禁用")
    private Boolean enabled;

}
