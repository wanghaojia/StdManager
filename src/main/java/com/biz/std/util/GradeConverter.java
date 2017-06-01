package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.vo.grade.GradeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级的VO/PO转换类
 * Created by haojia.wang on 2017/5/26.
 */
public class GradeConverter {

    private GradeConverter(){
        super();
    }

    /**
     * 班级po转vo
     */
    public static GradeVo toVo(Grade grade){
        GradeVo gradeVo = new GradeVo();
        gradeVo.setId(grade.getId());
        gradeVo.setName(grade.getName());
        gradeVo.setCount(grade.getStudents().size());
        List<Score> scoreList = new ArrayList<>();
        for (Student student: grade.getStudents()) {
            scoreList.addAll(student.getScores());
        }
        gradeVo.setAvgScore(Utils.avgScore(scoreList));
        return gradeVo;
    }

    /**
     * 班级vo转po
     */
    public static Grade toPo(GradeVo gradeVo){
        Grade grade = new Grade();
        grade.setId(gradeVo.getId());
        grade.setName(gradeVo.getName());
        return grade;
    }

    /**
     * 班级vo集合转po集合
     */
    public static List<Grade> toPoList(List<GradeVo> gradeVoList){
        List<Grade> gradeList = new ArrayList<>();
        for (GradeVo gradeVo: gradeVoList) {
            gradeList.add(toPo(gradeVo));
        }
        return gradeList;
    }

    /**
     * 班级po集合转vo集合
     */
    public static List<GradeVo> toVoList(List<Grade> gradeList){
        List<GradeVo> gradeVoList = new ArrayList<>();
        for (Grade grade: gradeList) {
            gradeVoList.add(toVo(grade));
        }
        return gradeVoList;
    }

}
