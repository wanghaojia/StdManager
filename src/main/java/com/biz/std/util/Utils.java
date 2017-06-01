package com.biz.std.util;

import com.biz.std.model.Score;
import com.biz.std.vo.PageVo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * 工具类
 * Created by haojia.wang on 2017/5/25.
 */
public class Utils {

    /**
     * 从一个Page对象中获取一个分页信息对象
     */
    public static PageVo getPageVo(Page page){
        PageVo pageVo = new PageVo();
        pageVo.setPageIndex(page.getNumber()+1);
        pageVo.setPageSize(page.getNumberOfElements());
        pageVo.setPageCount(page.getTotalPages());
        pageVo.setTotalElements(page.getTotalElements());
        pageVo.setHasPrevious(page.hasPrevious());
        pageVo.setHasNext(page.hasNext());
        return pageVo;
    }

    /**
     * 计算平均分
     */
    public static BigDecimal avgScore(List<Score> scores){
        BigDecimal avgScore = new BigDecimal(new BigInteger("0"),2);
        if (scores.size() > 0){
            BigDecimal sum = new BigDecimal("0");
            for (Score score: scores) {
                sum = sum.add(score.getScore());
            }
            BigDecimal count = new BigDecimal(String.valueOf(scores.size()));
            avgScore =  sum.divide(count, 2, BigDecimal.ROUND_HALF_UP);
        }
        return avgScore;
    }

}
