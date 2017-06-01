package com.biz.std.service;

import com.biz.std.vo.score.ScoreVo;

/**
 * 对分数进行操作的服务类
 */
public interface ScoreService {

    /**
     * 获取指定学生指定科目的分数
     */
    ScoreVo getScore(Long studentId,Long subjectId);

}
