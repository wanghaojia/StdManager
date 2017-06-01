package com.biz.std.vo.student;

import com.biz.std.vo.score.ScoreVo;

import java.util.List;

/**
 * 学生学科VO
 */
public class StdSubVo {

    /**
     * 学科分数列表
     */
    private List<ScoreVo> scoreVoList;

    /**
     * 选课的学生
     */
    private StudentVo studentVo;

    public List<ScoreVo> getScoreVoList() {
        return scoreVoList;
    }

    public void setScoreVoList(List<ScoreVo> scoreVoList) {
        this.scoreVoList = scoreVoList;
    }

    public StudentVo getStudentVo() {
        return studentVo;
    }

    public void setStudentVo(StudentVo studentVo) {
        this.studentVo = studentVo;
    }
}
