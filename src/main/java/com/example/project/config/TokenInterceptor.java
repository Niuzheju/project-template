package com.example.project.config;



import com.example.project.authorization.Const;
import com.example.project.authorization.CurrentUser;
import com.example.project.bean.Permission;
import com.example.project.bean.UserPermission;
import com.example.project.common.exception.RestException;
import com.example.project.common.response.ResponseCode;
import com.example.project.entity.SysUserEntity;
import com.example.project.error.AuthorizationError;
import com.example.project.error.LoginError;
import com.example.project.mapper.SysUserMapper;
import com.example.project.service.UserPermissionService;
import com.example.project.util.TokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private UserPermissionService userPermissionService;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        //解析Token信息
        try {
            //权限路径拦截
            String headerToken = request.getHeader(Const.AUTH);
            if (StringUtils.isBlank(headerToken)) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_NOT_EXIST_ERROR)
                        .withError(LoginError.NO_TOKEN_ERROR)
                        .build();
            }
            headerToken = headerToken.replace(Const.TOKEN_PREFIX, "");

            Claims claims = TokenUtil.getTokenParams(headerToken);

            if (!this.profile.equals(claims.get("profile"))) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                        .withError(LoginError.TOKEN_ERROR)
                        .build();
            }

            //有效期验证
            Date expiration = claims.getExpiration();
            if (expiration.before(new Date())) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_EXPIRED_ERROR)
                        .withError(LoginError.TOKEN_EXPIRE_ERROR)
                        .build();
            }

            CurrentUser currentUser = new CurrentUser();
            long tokenUserId = Long.parseLong(String.valueOf(claims.get("userId")));
            SysUserEntity user = userMapper.getByIdAndEnabled(tokenUserId);
            //不存在用户信息则认定token不合法
            if (null == user) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                        .withError(LoginError.TOKEN_ERROR)
                        .build();
            }

            currentUser.setId(user.getId());
            currentUser.setUsername(user.getUsername());
            request.setAttribute("CURRENT_USER", currentUser);

            if ("dev".equals(profile) && "admin".equals(user.getUsername())) {
                return true;
            }

            String requestURI = request.getRequestURI().replace("/public", "");
            if (isFreeRequest(request.getMethod(), requestURI)) {
                return true;
            }

            UserPermission userPermission = userPermissionService.getUserPermission(user.getId());

            List<String> roleList = userPermission.getRole();
            List<Permission> permissionList = userPermission.getPermission();

            if (CollectionUtils.isEmpty(roleList)) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                        .withError(AuthorizationError.PERMISSION_DENIED)
                        .build();
            }
            if (CollectionUtils.isEmpty(permissionList)) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                        .withError(AuthorizationError.PERMISSION_DENIED)
                        .build();
            }

            boolean permit = permissionList.stream()
                    .anyMatch(t -> request.getMethod().equalsIgnoreCase(t.getMethod()) && requestURI.contains(t.getApi()));

            if (!permit) {
                throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                        .withError(AuthorizationError.PERMISSION_DENIED)
                        .build();
            }

            return true;
        } catch (Exception e) {
            if (e instanceof RestException) {
                throw e;
            }
            throw new RestException.Builder(ResponseCode.ACCESS_TOKEN_INVALID_ERROR)
                    .withError(LoginError.TOKEN_ERROR)
                    .withCause(e)
                    .build();
        }

    }

    private boolean isFreeRequest(String method, String uri) {
        return FREE_URI.stream().anyMatch(t -> method.equalsIgnoreCase(t.getMethod()) && uri.contains(t.getApi()));
    }

    private final static List<Permission> FREE_URI = new ArrayList<>();

    static {
        FREE_URI.add(new Permission("GET", "/sys/user"));
        FREE_URI.add(new Permission("PUT", "/sys/user/password"));
    }
}
