package com.example.project.util;

/**
 * @Author niuzheju
 * @Date 13:57 2024/4/30
 */
public class EnumUtil {

    /**
     * 通过枚举的class和名称获取枚举
     */
    public static <E extends Enum<E>> E getEnum(final Class<E> enumClass, final String enumName) {
        if (null == enumName) {
            return null;
        }
        try {
            return Enum.valueOf(enumClass, enumName);
        } catch (final IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 判断一个枚举中是否包含指定值
     */
    public static boolean hasEnum(final Class enumClass, final String enumName) {
        return null != getEnum(enumClass, enumName);
    }
}
