package com.example.project.service;

import com.example.project.entity.AreaEntity;
import com.example.project.mapper.AreaMapper;
import com.example.project.util.BeanCopyUtil;
import com.example.project.vo.AreaVO;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Author niuzheju
 * @Date 14:24 2024/4/25
 */
@Service
public class AreaService {

    @Setter(onMethod_ = @Autowired)
    private AreaMapper areaMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaService.class);

    public AreaVO getAreaById(Long id) {
        AreaEntity areaEntity = areaMapper.getAreaById(id);
        if (areaEntity == null) {
            return null;
        }
        AreaVO areaVO = BeanCopyUtil.copyBean(areaEntity, AreaVO.class);

        List<AreaVO> children = getChildren(areaEntity.getId());
        areaVO.setChildrenList(children);

        return areaVO;
    }

    private List<AreaVO> getChildren(Long id) {
        List<AreaEntity> childrenList = areaMapper.getAreaByParentId(id);
        if (CollectionUtils.isEmpty(childrenList)) {
            return Collections.emptyList();
        }

        List<AreaVO> areaVOList = BeanCopyUtil.copyList(childrenList, AreaVO.class);

        for (AreaVO areaVO : areaVOList) {
            areaVO.setChildrenList(getChildren(areaVO.getId()));
        }

        return areaVOList;
    }
}
