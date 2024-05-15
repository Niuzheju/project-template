package com.example.project.mapper;

import com.example.project.entity.SysPermissionEntity;
import com.example.project.request.PermissionParamRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysPermissionMapper {
    int countPermissionByPermissionKeys(@Param("keys") List<String> keys);

    int countByPermissions(@Param("permissions") List<PermissionParamRequest> permissions);

    List<SysPermissionEntity> getPermissionList();

    int addPermissions(@Param("permissions") List<SysPermissionEntity> permissions);

    int delPermissions(@Param("keys") List<String> keys);
}
