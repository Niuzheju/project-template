package com.example.project.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author niuzheju
 * @Date 14:01 2024/4/30
 */
public class Md5Util {

    /**
     * 获取32位md5值
     */
    public static String getMd5(String string) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert m != null;
        byte[] digest = m.digest(string.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        return bigInt.toString(16);
    }

    public static String getMd5(List<String> stringList) {
        String joinedString = stringList.stream().sorted()
                .collect(Collectors.joining("-"));
        return Md5Util.getMd5(joinedString);
    }


}
