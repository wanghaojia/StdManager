package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.util.ScoreConverter;
import com.biz.std.util.StudentConverter;
import com.biz.std.util.Utils;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.PageVo;
import com.biz.std.vo.score.ScoreVo;
import com.biz.std.vo.student.StdSubVo;
import com.biz.std.vo.student.StudentListVo;
import com.biz.std.vo.student.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息操作的实现类
 * Created by haojia.wang on 2017/5/25.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScoreService scoreService;

    @Override
    public StudentListVo findStudentList(PageReqVo reqVo) {
        Page<Student> students = studentRepository.findAll(new Specification<Student>() {
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

//                predicates.add(cb.equal(root.get("name").as(String.class),"王昊佳"));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },new PageRequest(reqVo.getPageIndex()-1,reqVo.getPageSize()));
        PageVo pageVo = Utils.getPageVo(reqVo,students);
        List<StudentVo> studentVoList = StudentConverter.toVoList(students.getContent());
        return new StudentListVo(pageVo,studentVoList);
    }

    @Override
    public StudentVo getStudent(Long id) {
        Student student = studentRepository.findOne(id);
        if (student != null){
            return StudentConverter.toVo(student);
        }
        return null;
    }

    @Override
    public void saveStudent(StudentVo studentVo) {
        Student student = StudentConverter.toPo(studentVo);
        studentRepository.save(student);
    }


    @Override
    public void saveStudent(StdSubVo stdSubVo) {
        Student student = studentRepository.findOne(stdSubVo.getStudentVo().getId());
        List<ScoreVo> scoreList = stdSubVo.getScoreVoList();
        List<Score> checkedScoreList = new ArrayList<>();
        if (scoreList != null){
            for (ScoreVo scoreVo:scoreList) {
                if (scoreVo.getScore() == null){
                    //如果是选课保存，则设置默认分数为0
                    scoreVo.setScore(new BigDecimal("0"));
                    //如果是选课保存，并且信息该条信息没有被选中，则进入跳过该信息
                    if (!scoreVo.isChecked()) continue;
                }
                Score score = ScoreConverter.toPo(scoreVo);
                ScoreVo existScoreVo = scoreService.getScore(student.getId(), scoreVo.getSubjectId());
                if (existScoreVo != null) {
                    //如果该生选择该门课程信息已经存在，则引用该信息ID，覆盖数据，不会重新创建一条数据
                    score.setId(existScoreVo.getId());
                }
                score.setStudent(student);
                checkedScoreList.add(score);
            }
        }
        student.setScores(checkedScoreList);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }
}
