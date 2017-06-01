package com.biz.std.vo.grade;

import com.biz.std.vo.PageVo;

import java.util.List;

/**
 * 班级页面信息VO
 * Created by haojia.wang on 2017/5/26.
 */
public class GradeListVo {

    /**
     * 分页信息VO
     */
    private PageVo pageVo;

    /**
     * 班级信息列表VO
     */
    private List<GradeVo> gradeVoList;

    public GradeListVo(){
        super();
    }

    public GradeListVo(PageVo pageVo, List<GradeVo> gradeVoList) {
        this();
        this.pageVo = pageVo;
        this.gradeVoList = gradeVoList;
    }

    public PageVo getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo pageVo) {
        this.pageVo = pageVo;
    }

    public List<GradeVo> getGradeVoList() {
        return gradeVoList;
    }

    public void setGradeVoList(List<GradeVo> gradeVoList) {
        this.gradeVoList = gradeVoList;
    }

}
