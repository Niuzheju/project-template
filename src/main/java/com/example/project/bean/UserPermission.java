package com.example.project.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserPermission {

    private List<String> role;

    /**
     * 从permission中获取到的key会重复
     * 如 userPermission.getPermission().stream().map(Permission::getKey)
     * 需要在map()后面跟distinct()过滤
     */
    private List<Permission> permission;

    public UserPermission() {
    }

    public UserPermission(List<String> role, List<Permission> permission) {
        this.role = role;
        this.permission = permission;
    }


}
