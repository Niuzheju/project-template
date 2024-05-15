package com.example.project.service;

import com.example.project.bean.Permission;
import com.example.project.bean.RedisKeyConst;
import com.example.project.bean.UserPermission;
import com.example.project.entity.SysRoleEntity;
import com.example.project.mapper.SysRolePermissionMapper;
import com.example.project.mapper.SysUserRoleMapper;
import com.example.project.util.RedisUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPermissionService {

    @Value("${project.authorization.expire}")
    private long authorizationExpire;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 获取用户权限, 如果缓存中有就直接返回, 没有则查库, 缓存并返回
     *
     * @param userId 用户id
     */
    public UserPermission getUserPermission(Long userId) {
        UserPermission up = (UserPermission) redisUtil.get(RedisKeyConst.USER_PERMISSION + userId);
        if (up != null) {
            return up;
        } else {
            return cacheUserPermission(userId);
        }
    }

    /**
     * 从数据查询权限并缓存, 返回
     *
     * @param userId 用户id
     */
    public UserPermission cacheUserPermission(Long userId) {
        List<SysRoleEntity> sysRoleEntityList = sysUserRoleMapper.getRoleListByUserId(userId);
        List<String> roleList = sysRoleEntityList.stream().map(SysRoleEntity::getRoleZH).collect(Collectors.toList());
        List<Permission> permissionList = null;
        if (CollectionUtils.isNotEmpty(sysRoleEntityList)) {
            permissionList = sysRolePermissionMapper.getPermissionListByRoleIds(
                    sysRoleEntityList.stream().map(SysRoleEntity::getId).collect(Collectors.toList()));
            if (CollectionUtils.isNotEmpty(permissionList)) {
                redisUtil.set(RedisKeyConst.USER_PERMISSION + userId, new UserPermission(roleList, permissionList), authorizationExpire);
            }
        }
        return new UserPermission(roleList, permissionList == null ? Collections.emptyList() : permissionList);
    }


}
