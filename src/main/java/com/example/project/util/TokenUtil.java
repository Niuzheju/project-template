package com.example.project.util;

import com.example.project.authorization.Const;
import com.example.project.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.collections4.MapUtils;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * jjwt-api
 *
 * @Author niuzheju
 * @Date 14:45 2024/4/30
 */
public class TokenUtil {

    /**
     * 生成token
     *
     * @param expireDate 有效日期
     * @param claims     自定义参数
     */
    public static String creatToken(Date expireDate, Map<String, String> claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .header()
                .add("typ", Const.JWT_TYP)
                .add("alg", Const.JWT_ALG)
                .and()
                .issuedAt(new Date())
                .expiration(expireDate);
        if (MapUtils.isNotEmpty(claims)) {
            for (Map.Entry<String, String> entry : claims.entrySet()) {
                jwtBuilder.claim(entry.getKey(), entry.getValue());
            }
        }

        jwtBuilder.signWith(new SecretKeySpec(Const.JWT_SIGN_KEY.getBytes(), Const.JWT_ALG));
        return jwtBuilder.compact();
    }

    /**
     * 生成token
     *
     * @param user       用户信息
     * @param expireDate 有效日期
     */
    public static String creatToken(UserEntity user, Date expireDate, String profile) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .header().add("typ", Const.JWT_TYP)
                .add("alg", Const.JWT_ALG)
                .and()
                .issuedAt(new Date())
                .expiration(expireDate)
                .claim("userId", String.valueOf(user.getId()))
                .claim("mobile", user.getMobile())
                .claim("role", user.getRole())
                .claim("profile", profile)
                .signWith(new SecretKeySpec(Const.JWT_SIGN_KEY.getBytes(), Const.JWT_ALG));
        return jwtBuilder.compact();
    }

    /**
     * 获取token中的参数
     */
    public static Claims getTokenParams(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(new SecretKeySpec(Const.JWT_SIGN_KEY.getBytes(), Const.JWT_ALG))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
