package com.biz.std.repository;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 分数信息的数据库操作接口
 */
public interface ScoreRepository extends JpaRepository<Score,Long>,JpaSpecificationExecutor<Score> {

    /**
     * 获取指定学生指定科目的成绩
     */
    Score getScoreByStudentAndSubject(Student student, Subject subject);

}
