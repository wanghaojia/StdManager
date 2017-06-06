package com.biz.std.service.impl;

import com.biz.std.model.Grade;
import com.biz.std.repository.GradeRepository;
import com.biz.std.service.GradeService;
import com.biz.std.util.GradeConverter;
import com.biz.std.util.Utils;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.PageVo;
import com.biz.std.vo.grade.GradeListVo;
import com.biz.std.vo.grade.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 班级信息操作的实现类
 * Created by haojia.wang on 2017/5/26.
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<GradeVo> findGradeList() {
        List<Grade> gradeList = gradeRepository.findAll();
        return GradeConverter.toVoList(gradeList);
    }

    @Override
    public GradeListVo findGradeList(PageReqVo reqVo) {
        Page<Grade> grades = gradeRepository.findAll(new Specification<Grade>() {
            @Override
            public Predicate toPredicate(Root<Grade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        },new PageRequest(reqVo.getPageIndex()-1,reqVo.getPageSize()));
        List<GradeVo> gradeVoList = GradeConverter.toVoList(grades.getContent());
        PageVo pageVo = Utils.getPageVo(reqVo,grades);
        return new GradeListVo(pageVo,gradeVoList);
    }

    @Override
    public void saveGrade(GradeVo gradeVo) {
        gradeRepository.save(GradeConverter.toPo(gradeVo));
    }

    @Override
    public GradeVo getGrade(String name) {
        Grade grade = gradeRepository.getGradeByName(name);
        if (grade != null){
            return GradeConverter.toVo(grade);
        }
        return null;
    }

    @Override
    public GradeVo getGrade(Long id) {
        Grade grade = gradeRepository.findOne(id);
        if (grade != null){
            return GradeConverter.toVo(grade);
        }
        return null;
    }


    @Override
    public void deleteGrade(Long id) {
        gradeRepository.delete(id);
    }
}
