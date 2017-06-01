package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.vo.student.StudentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生实体的VO/PO转换类
 */
public class StudentConverter {

    private StudentConverter(){
        super();
    }

    /**
     * 将学生VO转换成po
     */
    public static Student toPo(StudentVo studentVo){
        Student student = new Student();
        student.setId(studentVo.getId());
        student.setName(studentVo.getName());
        student.setSex(studentVo.getSex());
        student.setBirthday(studentVo.getBirthday());
        Grade grade = new Grade();
        grade.setId(studentVo.getGradeId());
        student.setGrade(grade);
        student.setPicture(studentVo.getPicture());
        student.setScores(ScoreConverter.toPoList(studentVo.getScoreVoList()));
        return student;
    }

    /**
     * 将学生po转换成vo
     */
    public static StudentVo toVo(Student student){
        StudentVo studentVo = new StudentVo();
        studentVo.setId(student.getId());
        studentVo.setName(student.getName());
        studentVo.setSex(student.getSex());
        studentVo.setBirthday(student.getBirthday());
        studentVo.setGradeId(student.getGrade().getId());
        studentVo.setGradeName(student.getGrade().getName());
        studentVo.setPicture(student.getPicture());
        studentVo.setSubjectCount(student.getScores().size());
        studentVo.setScoreVoList(ScoreConverter.toVoList(student.getScores()));
        studentVo.setAvgScore(Utils.avgScore(student.getScores()));
        return studentVo;
    }

    public static List<Student> toPoList(List<StudentVo> studentVoList){
        List<Student> studentList = new ArrayList<>();
        for (StudentVo studentVo: studentVoList) {
            studentList.add(toPo(studentVo));
        }
        return studentList;
    }

    public static List<StudentVo> toVoList(List<Student> studentList){
        List<StudentVo> studentVoList = new ArrayList<>();
        for (Student student: studentList) {
            studentVoList.add(toVo(student));
        }
        return studentVoList;
    }

}
