package com.example.project.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleRequest extends BaseUpdateRequest {
    private Long roleId;

    @NotBlank(message = "角色不能为空")
    @Pattern(regexp = "^[A-Za-z0-9-_]+$", message = "[角色]只允许输入英文数字和下划线")
    private String role;

    @NotBlank(message = "角色中文名不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa50-9-\\_]+$", message = "[角色中文]只允许输入中文数字和下划线")
    private String roleZH;

    private Boolean enabled;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleZH() {
        return roleZH;
    }

    public void setRoleZH(String roleZH) {
        this.roleZH = roleZH;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
