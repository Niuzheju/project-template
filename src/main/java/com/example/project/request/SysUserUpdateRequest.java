package com.example.project.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUserUpdateRequest {

    private Long userId;

    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Pattern(regexp = "^1[0-9]{10}$", message = "请输入正确的手机号")
    private String mobile;

    private String email;

    private String updUsername;
}
