package com.biz.std.vo;

/**
 * 分页加载的VO
 * Created by haojia.wang on 2017/5/25.
 */
public class PageVo {

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 请求页面数据个数（页面大小）
     */
    private Integer pageSize;

    /**
     * 实际页面大小
     */
    private Integer relPageSize;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 数据总数
     */
    private Long totalElements;

    /**
     * 是否还有上一页
     */
    private boolean hasPrevious;

    /**
     * 是否还有下一页
     */
    private boolean hasNext;

    public Integer getRelPageSize() {
        return relPageSize;
    }

    public void setRelPageSize(Integer relPageSize) {
        this.relPageSize = relPageSize;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}
