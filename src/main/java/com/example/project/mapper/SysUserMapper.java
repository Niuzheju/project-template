package com.example.project.mapper;


import com.example.project.entity.SysUserEntity;
import com.example.project.request.SysUserEnableRequest;
import com.example.project.request.SysUserPasswordRequest;
import com.example.project.request.SysUserQuery;
import com.example.project.request.SysUserUpdateRequest;
import com.example.project.response.SysUserResponse;

import java.util.List;


public interface SysUserMapper {
    SysUserEntity getById(long id);

    SysUserEntity getByUsername(String username);

    SysUserEntity getByIdAndEnabled(long id);

    int createSysUser(SysUserEntity entity);

    List<SysUserResponse> getSysUserList(SysUserQuery sysUserQuery);

    int updateSysUser(SysUserUpdateRequest request);

    int enableSysUser(SysUserEnableRequest request);

    int updatePassword(SysUserPasswordRequest request);
}
