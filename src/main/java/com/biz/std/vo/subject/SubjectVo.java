package com.biz.std.vo.subject;

import com.biz.std.model.Subject;

import java.math.BigDecimal;

/**
 * 学科类
 * Created by haojia.wang on 2017/5/25.
 */
public class SubjectVo {

    //科目ID
    private Long id;

    //学科名
    private String name;

    //选修该课程的人数
    private Integer count;

    //平均分
    private BigDecimal avgScore;

    public SubjectVo(){
        super();
    }

    public SubjectVo(Subject subject){
        this();
        this.id = subject.getId();
        this.name = subject.getName();
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getCount() {
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
