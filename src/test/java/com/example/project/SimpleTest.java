package com.example.project;

import com.example.project.util.DateUtil;
import com.example.project.util.Md5Util;
import com.example.project.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author niuzheju
 * @Date 14:03 2024/4/30
 */
public class SimpleTest {

    @Test
    void test01() {
        String md5 = Md5Util.getMd5("hecai");
        System.out.println(md5);
        System.out.println(md5.length());
    }

    @Test
    void test02() {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(10);
        Map<String, String> map = new HashMap<>();
        map.put("name", "niuzheju");
        map.put("age", "20");
        String token = TokenUtil.creatToken(DateUtil.asDate(localDateTime), map);
        System.out.println(token);
    }

    @Test
    void test03() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTQ5Nzg1NjcsImV4cCI6MTcxNDk3OTE2NywibmFtZSI6Im5pdXpoZWp1IiwiYWdlIjoiMjAifQ.oA3Sx5OdpXQUxzrAZJpIP5X9Kj8Rm_t4ESHpErN1DHA";
        Claims claims = TokenUtil.getTokenParams(token);
        System.out.println(claims);
    }
}
