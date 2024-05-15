package com.example.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author niuzheju
 * @Date 13:48 2024/4/30
 */
public class BeanCopyUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCopyUtil.class);

    /**
     * list复制
     * 需要保证里面的属性一致
     */
    public static <F, T> List<T> copyList(List<F> fromList, Class<T> tClass) {
        List<T> tList = new ArrayList<>();
        if (CollectionUtils.isEmpty(fromList)) {
            return tList;
        }
        for (F f : fromList) {
            T t = copyBean(f, tClass);
            tList.add(t);
        }
        return tList;
    }

    /**
     * 属性复制
     */
    public static <F, T> T copyBean(F entity, Class<T> modelClass) {
        try {
            if (entity == null) {
                throw new NullPointerException("entity is null");
            }
            T model = modelClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, model);
            return model;
        } catch (Exception e) {
            LOGGER.error("bean copy error", e);
            throw new RuntimeException(e);
        }
    }
}
