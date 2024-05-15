package com.example.project.mapper;

import com.example.project.entity.SysRoleEntity;
import com.example.project.request.EnableRoleRequest;
import com.example.project.request.RoleRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    List<SysRoleEntity> getRoleList();

    SysRoleEntity getRoleByRoleId(long id);

    SysRoleEntity getByRoleZH(String roleZH);

    SysRoleEntity getByRole(String role);

    SysRoleEntity getByRoleOrRoleZH(@Param("role") String role, @Param("roleZH") String roleZH);

    void addRole(RoleRequest role);

    void updRole(RoleRequest role);

    void enableRole(EnableRoleRequest role);

    int countByRoleIds(@Param("roleIds") List<Long> roleIds);

    List<SysRoleEntity> getRoleListByUsername(String username);
}
