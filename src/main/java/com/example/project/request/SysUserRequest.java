package com.example.project.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Setter
@Getter
public class SysUserRequest {

    @NotBlank(message = "昵称不能为空")
    @Length(min = 1, max = 32, message = "用户昵称长度应在1-32之间")
    private String nickname;

    @Length(min = 2, max = 32, message = "用户名长度应在2-32之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    private String password;

    @Pattern(regexp = "^1[0-9]{10}$", message = "请输入正确的手机号")
    private String mobile;

    private String email;
    private Boolean enabled = Boolean.TRUE;
    private String crtUsername;

}
