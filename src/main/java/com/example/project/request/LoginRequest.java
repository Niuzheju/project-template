package com.example.project.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Setter
@Getter
public class LoginRequest {
    @Length(min = 2, max = 32, message = "用户名长度必须在2-32之间")
    @NotBlank(message = "用户名或密码不能为空")
    private String username;

    @NotBlank(message = "用户名或密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
