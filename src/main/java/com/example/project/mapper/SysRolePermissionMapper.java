package com.example.project.mapper;

import com.example.project.bean.Permission;
import com.example.project.entity.SysRolePermissionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRolePermissionMapper {
    List<Permission> getPermissionListByRoleIds(@Param("roleIds") List<Long> roleIds);

    List<String> getKeyListByRoleId(@Param("roleId") long roleId);

    List<String> getKeyListByRoleIdAndKeys(@Param("roleId") long roleId, @Param("keys") List<String> keys);

    int addRolePermissions(@Param("entityList") List<SysRolePermissionEntity> entityList);

    int delRolePermissionsByRoleIdAndKeys(@Param("roleId") long roleId, @Param("keys") List<String> keys);
}
