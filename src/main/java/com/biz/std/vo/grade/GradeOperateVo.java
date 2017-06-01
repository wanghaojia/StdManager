package com.biz.std.vo.grade;

/**
 * 新建班级和更新班级VO
 */
public class GradeOperateVo {

    /**
     * 班级信息
     */
    private GradeVo gradeVo;

    /**
     * 错误信息
     */
    private String error;

    public GradeVo getGradeVo() {
        return gradeVo;
    }

    public void setGradeVo(GradeVo gradeVo) {
        this.gradeVo = gradeVo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
