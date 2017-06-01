package com.biz.std.vo;

import java.util.Map;

/**
 * 页面请求VO
 * Created by haojia.wang on 2017/5/25.
 */
public class PageReqVo {

    /**
     * 点击了第几页
     */
    private int pageIndex = 1;

    /**
     * 页面大小、容量
     */
    private int pageSize = 10;

    /**
     * 参数
     */
    private Map<String,String> params;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

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
}
