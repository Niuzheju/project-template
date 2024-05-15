package com.example.project.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserUpdatePasswordRequest {

    private Long userId;

    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{8,16}$", message = "必须包含字母和数字的组合，长度在8~16之间")
    private String newPassword;

    private String updUsername;

}
