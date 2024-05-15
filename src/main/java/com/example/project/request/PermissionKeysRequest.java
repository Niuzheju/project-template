package com.example.project.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class PermissionKeysRequest {

    @NotEmpty(message = "权限key为空")
    private List<String> keys;

}
