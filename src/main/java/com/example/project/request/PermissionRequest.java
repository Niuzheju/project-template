package com.example.project.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PermissionRequest extends BaseUpdateRequest {

    @NotEmpty(message = "权限为空")
    private List<PermissionParamRequest> permissions;

}
