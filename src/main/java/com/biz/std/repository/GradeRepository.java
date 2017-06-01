package com.biz.std.repository;

import com.biz.std.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 班级实体数据库操作
 * Created by haojia.wang on 2017/5/26.
 */
public interface GradeRepository extends JpaRepository<Grade,Long>,JpaSpecificationExecutor<Grade> {

    /**
     * 通过班级名查找班级信息
     */
    Grade getGradeByName(String name);

}
