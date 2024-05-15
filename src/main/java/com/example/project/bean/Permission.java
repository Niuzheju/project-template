package com.example.project.bean;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Permission {

    private String key;
    private String method;
    private String api;

    public Permission() {
    }

    public Permission(String method, String api) {
        this.method = method;
        this.api = api;
    }

}
