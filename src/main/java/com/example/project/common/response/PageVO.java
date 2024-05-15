package com.example.project.common.response;

import com.github.pagehelper.PageInfo;

import java.io.Serial;
import java.io.Serializable;


public class PageVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5359692079261936687L;

    /**
     * 第几页
     */
    private int pageIndex;
    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int totalAmount;

    /**
     * 总页数
     */
    private int totalPage;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPage() {
        int totalPage = totalAmount / pageSize;
        if (totalAmount % pageSize != 0) {
            return totalPage + 1;
        }
        return totalPage;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PageVO() {
    }

    public PageVO(int pageIndex, int pageSize, int totalAmount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalAmount = totalAmount;
    }

    @SuppressWarnings("rawtypes")
    public PageVO(PageInfo pageInfo) {
        this.pageIndex = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalAmount = (int)pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
    }
}
