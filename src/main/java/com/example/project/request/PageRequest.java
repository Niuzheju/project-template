package com.example.project.request;

/**
 * @author: Richie
 * @date: 16:17  2020/8/14
 */
public class PageRequest {
    private Integer pageIndex = 1;  //第几页，默认第一页
    private Integer pageSize = 10;  //每页记录数，默认10条

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
