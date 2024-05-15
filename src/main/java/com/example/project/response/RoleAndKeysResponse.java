package com.example.project.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RoleAndKeysResponse extends RoleResponse {

    private String role;
    private Boolean enabled;
    private List<String> keys;


}
