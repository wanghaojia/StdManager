package com.biz.std.util;

import com.biz.std.model.Subject;
import com.biz.std.vo.subject.SubjectVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 学科实体的VO/PO转换类
 */
public class SubjectConverter {


    private SubjectConverter(){
        super();
    }

    /**
     * 学科po转vo
     */
    public static SubjectVo toVo(Subject subject){
        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setId(subject.getId());
        subjectVo.setName(subject.getName());
        subjectVo.setCount(subject.getScores().size());
        subjectVo.setAvgScore(Utils.avgScore(subject.getScores()));
        return subjectVo;
    }

    /**
     * 学科vo转po
     */
    public static Subject toPo(SubjectVo subjectVo){
        Subject subject = new Subject();
        subject.setId(subjectVo.getId());
        subject.setName(subjectVo.getName());
        return subject;
    }

    /**
     * 学科vo集合转po集合
     */
    public static List<Subject> toPoList(List<SubjectVo> subjectVoList){
        List<Subject> subjectList = new ArrayList<>();
        for (SubjectVo subjectVo: subjectVoList) {
            subjectList.add(toPo(subjectVo));
        }
        return subjectList;
    }

    /**
     * 学科po集合转vo集合
     */
    public static List<SubjectVo> toVoList(List<Subject> subjectList){
        List<SubjectVo> subjectVoList = new ArrayList<>();
        for (Subject subject: subjectList) {
            subjectVoList.add(toVo(subject));
        }
        return subjectVoList;
    }

}
