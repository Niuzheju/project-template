package com.example.project.authorization;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrentUser {
    private long id;
    private String username;
    private String role;
    private String mobile;


}
