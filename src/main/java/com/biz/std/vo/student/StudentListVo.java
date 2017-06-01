package com.biz.std.vo.student;

import com.biz.std.vo.PageVo;

import java.util.List;

/**
 * 学生页面信息VO
 * Created by haojia.wang on 2017/5/25.
 */
public class StudentListVo {

    /**
     * 分页信息VO
     */
    private PageVo pageVo;

    /**
     * 学生信息列表VO
     */
    private List<StudentVo> studentVoList;

    public StudentListVo(){
        super();
    }

    public StudentListVo(PageVo pageVo, List<StudentVo> studentVoList) {
        this();
        this.pageVo = pageVo;
        this.studentVoList = studentVoList;
    }

    public PageVo getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo pageVo) {
        this.pageVo = pageVo;
    }

    public List<StudentVo> getStudentVoList() {
        return studentVoList;
    }

    public void setStudentVoList(List<StudentVo> studentVoList) {
        this.studentVoList = studentVoList;
    }
}
