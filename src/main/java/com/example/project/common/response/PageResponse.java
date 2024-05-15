package com.example.project.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Setter
@Getter
public class PageResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5359692079261936687L;

    private List<T> list;
    private PageVO page;

}
