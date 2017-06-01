package com.biz.std.repository;

import com.biz.std.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 学生实体数据库操作
 * Created by haojia.wang on 2017/5/25.
 */
public interface StudentRepository extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student>{

}
