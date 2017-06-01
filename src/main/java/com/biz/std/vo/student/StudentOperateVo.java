package com.biz.std.vo.student;

import com.biz.std.vo.grade.GradeVo;

import java.util.List;

/**
 * 新建或者修改学生信息VO
 */
public class StudentOperateVo {

    /**
     * 学生信息
     */
    private StudentVo studentVo;

    /**
     * 班级集合
     */
    private List<GradeVo> gradeVoList;

    /**
     * 错误信息
     */
    private String error;

    public List<GradeVo> getGradeVoList() {
        return gradeVoList;
    }

    public void setGradeVoList(List<GradeVo> gradeVoList) {
        this.gradeVoList = gradeVoList;
    }

    public StudentVo getStudentVo() {
        return studentVo;
    }

    public void setStudentVo(StudentVo studentVo) {
        this.studentVo = studentVo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
