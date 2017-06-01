package com.biz.std.service;

import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.grade.GradeListVo;
import com.biz.std.vo.grade.GradeVo;

import java.util.List;

/**
 * 班级的操作服务类
 * Created by haojia.wang on 2017/5/25.
 */
public interface GradeService {

    /**
     * 获取所有班级信息集合
     */
    List<GradeVo> findGradeList();

    /**
     * 分页获取班级信息
     */
    GradeListVo findGradeList(PageReqVo reqVo);

    /**
     * 保存班级信息
     */
    void saveGrade(GradeVo gradeVo);

    /**
     * 通过班级名来查找班级信息
     */
    GradeVo getGrade(String name);

    /**
     * 通过班级ID来查找班级信息
     */
    GradeVo getGrade(Long id);

    /**
     * 删除班级信息
     */
    void deleteGrade(Long id);

}
