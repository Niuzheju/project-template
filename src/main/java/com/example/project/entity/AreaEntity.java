package com.example.project.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AreaEntity {

    private Long id;
    private String name;
    private Long parentId;
    private Date createTime;

}
