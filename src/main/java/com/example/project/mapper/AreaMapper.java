package com.example.project.mapper;


import com.example.project.entity.AreaEntity;
import com.example.project.vo.AreaVO;

import java.util.List;

/**
 * @Author niuzheju
 * @Date 14:31 2024/4/25
 */
public interface AreaMapper {

    AreaEntity getAreaById(Long id);

    List<AreaEntity> getAreaByParentId(Long parentId);
}
