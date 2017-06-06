package com.biz.std.service.impl;

import com.biz.std.model.Subject;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.SubjectService;
import com.biz.std.util.SubjectConverter;
import com.biz.std.util.Utils;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.PageVo;
import com.biz.std.vo.subject.SubjectListVo;
import com.biz.std.vo.subject.SubjectVo;
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
 * 学科信息操作的实现类
 * Created by haojia.wang on 2017/5/26.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<SubjectVo> findSubjectList() {
        List<Subject> subjectList = subjectRepository.findAll();
        return SubjectConverter.toVoList(subjectList);
    }

    @Override
    public SubjectListVo findSubjectList(PageReqVo reqVo) {
        Page<Subject> subjects = subjectRepository.findAll(new Specification<Subject>() {
            @Override
            public Predicate toPredicate(Root<Subject> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        },new PageRequest(reqVo.getPageIndex()-1,reqVo.getPageSize()));
        List<SubjectVo> subjectVoList = SubjectConverter.toVoList(subjects.getContent());
        PageVo pageVo = Utils.getPageVo(reqVo,subjects);
        return new SubjectListVo(pageVo,subjectVoList);
    }
    
    @Override
    public void saveSubject(SubjectVo subjectVo) {
        subjectRepository.save(SubjectConverter.toPo(subjectVo));
    }

    @Override
    public SubjectVo getSubject(String name) {
        Subject subject = subjectRepository.getSubjectByName(name);
        if (subject != null){
            return SubjectConverter.toVo(subject);
        }
        return null;
    }

    @Override
    public SubjectVo getSubject(Long id) {
        Subject Subject = subjectRepository.findOne(id);
        if (Subject != null){
            return SubjectConverter.toVo(Subject);
        }
        return null;
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.delete(id);
    }
}
