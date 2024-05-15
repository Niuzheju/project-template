package com.example.project.mapper;

import com.example.project.entity.SysRoleEntity;
import com.example.project.entity.SysUserRoleEntity;
import com.example.project.request.SysUserRoleRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    List<SysRoleEntity> getRoleListByUserId(long userId);

    List<Long> getUserIdListByRoleId(long roleId);

    int batchCreateSysUserRole(SysUserRoleRequest request);

    int batchCreateSysUserRoleByEntitys(@Param("roleEntities") List<SysUserRoleEntity> roleEntities);

    int delRolesByUserIdAndRoles(@Param("userId") long userId, @Param("roleIds") List<Long> roleIds);

    int delRolesByUserId(long userId);

    List<Long> getRoleIdListByUserId(long userId);
}
