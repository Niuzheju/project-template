package com.example.project.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Author niuzheju
 * @Date 14:21 2024/4/25
 */
@Setter
@Getter
public class AreaVO {

    private Long id;
    private String name;
    private Long parentId;
    private Date createTime;

    private List<AreaVO> childrenList;

}
