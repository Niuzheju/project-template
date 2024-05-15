package com.example.project.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PermissionParamRequest {

    @NotBlank(message = "key不能为空")
    private String key;

    @NotBlank(message = "method不能为空")
    private String method;

    @NotBlank(message = "api不能为空")
    private String api;

}
