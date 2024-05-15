package com.example.project.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PermissionResponse {

    private Long id;
    private String permission;
    private Boolean enabled;


}
