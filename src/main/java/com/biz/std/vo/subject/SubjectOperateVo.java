package com.biz.std.vo.subject;
/**
 * 新建学科和更新学科VO
 */
public class SubjectOperateVo {

    /**
     * 学科信息
     */
    private SubjectVo subjectVo;

    /**
     * 错误信息
     */
    private String error;

    public SubjectVo getSubjectVo() {
        return subjectVo;
    }

    public void setSubjectVo(SubjectVo subjectVo) {
        this.subjectVo = subjectVo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
