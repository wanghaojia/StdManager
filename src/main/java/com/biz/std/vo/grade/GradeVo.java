package com.biz.std.vo.grade;

import com.biz.std.model.Grade;

import java.math.BigDecimal;

/**
 * 班级类的VO类
 * Created by haojia.wang on 2017/5/25.
 */
public class GradeVo {


    //班级ID
    private Long id;

    //班级名
    private String name;

    //班级人数
    private Integer count;

    //平均分
    private BigDecimal avgScore;

    public GradeVo(){}

    public GradeVo(Grade grade){
        this.name = grade.getName();
        this.id = grade.getId();
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }
}
