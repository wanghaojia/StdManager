package com.biz.std.service;

import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.subject.SubjectListVo;
import com.biz.std.vo.subject.SubjectVo;

import java.util.List;

/**
 * 学科的操作服务类
 * Created by haojia.wang on 2017/5/25.
 */
public interface SubjectService {

    /**
     * 获取所有学科信息集合
     */
    List<SubjectVo> findSubjectList();

    /**
     * 分页获取学科信息
     */
    SubjectListVo findSubjectList(PageReqVo reqVo);

    /**
     * 保存学科信息
     */
    void saveSubject(SubjectVo subjectVo);

    /**
     * 通过学科名来查找学科信息
     */
    SubjectVo getSubject(String name);

    /**
     * 通过学科ID来查找学科信息
     */
    SubjectVo getSubject(Long id);

    /**
     * 删除指定学科
     */
    void deleteSubject(Long id);

}
