package com.example.project.util;

import com.example.project.enumeration.CodeEnum;

public class CodeEnumUtil {
    public static <E extends Enum<?> & CodeEnum> E codeOf(Class<E> enumClass, int status) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == status)
                return e;
        }
        return null;
    }
}
