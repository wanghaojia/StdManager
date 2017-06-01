package com.biz.std.vo.student;

import com.biz.std.vo.score.ScoreVo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * 学生信息类
 * Created by haojia.wang on 2017/5/25.
 */
public class StudentVo {

    //学号
    private Long id;

    //姓名
    private String name;

    //照片
    private String picture;

    //性别
    private Integer sex;

    //生日
    private Date birthday;

    //所在班级名字
    private String gradeName;

    //选修科目数
    private Integer subjectCount;

    //平均分
    private BigDecimal avgScore;

    //班级ID
    private Long gradeId;

    //科目及分数等信息集合
    private List<ScoreVo> scoreVoList;

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<ScoreVo> getScoreVoList() {
        return scoreVoList;
    }

    public void setScoreVoList(List<ScoreVo> scoreVoList) {
        this.scoreVoList = scoreVoList;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }
}
