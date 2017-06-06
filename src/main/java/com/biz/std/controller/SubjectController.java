package com.biz.std.controller;

import com.biz.std.service.SubjectService;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.subject.SubjectListVo;
import com.biz.std.vo.subject.SubjectOperateVo;
import com.biz.std.vo.subject.SubjectVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 学科信息的控制器
 * Created by haojia.wang on 2017/5/27.
 */
@Controller
@RequestMapping(value = "subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 学科信息列表
     */
    @RequestMapping(value = "list")
    public ModelAndView list(PageReqVo reqVo) {
        ModelAndView modelAndView = new ModelAndView("subject/list");
//        SubjectListVo subjectListVo = subjectService.findSubjectList(reqVo);
//        modelAndView.addObject("subjectListVo", subjectListVo);
        return modelAndView;
    }

    @RequestMapping(value = "listData")
    @ResponseBody
    public String listData(PageReqVo reqVo){
        SubjectListVo subjectListVo = subjectService.findSubjectList(reqVo);
        return new JSONObject(subjectListVo).toString();
    }

    /**
     * 添加学科信息页面
     */
    @RequestMapping(value = "new")
    public String newStudent() {
        return "subject/new";
    }

    /**
     * 执行添加学科操作
     */
    @RequestMapping(value = "save")
    public ModelAndView save(SubjectVo subjectVo) {
        SubjectVo existSubjectVo = subjectService.getSubject(subjectVo.getName());
        if (existSubjectVo == null){
            subjectService.saveSubject(subjectVo);
            return new ModelAndView("redirect:list.do");
        }else{
            ModelAndView modelAndView = new ModelAndView("subject/new");
            SubjectOperateVo subjectOperateVo = new SubjectOperateVo();
            subjectOperateVo.setError("学科名已经存在!");
            subjectOperateVo.setSubjectVo(subjectVo);
            modelAndView.addObject("subjectOperateVo",subjectOperateVo);
            return modelAndView;
        }
    }

    /**
     * 修改学科信息页面
     */
    @RequestMapping(value = "toUpdate")
    public ModelAndView toUpdate(SubjectVo subjectVo) {
        ModelAndView modelAndView = new ModelAndView("subject/update");
        subjectVo = subjectService.getSubject(subjectVo.getId());
        SubjectOperateVo subjectOperateVo = new SubjectOperateVo();
        subjectOperateVo.setSubjectVo(subjectVo);
        modelAndView.addObject("subjectOperateVo",subjectOperateVo);
        return modelAndView;
    }

    /**
     * 执行修改学科信息操作
     */
    @RequestMapping(value = "update")
    public ModelAndView update(SubjectVo subjectVo) {
        SubjectVo existSubjectVo = subjectService.getSubject(subjectVo.getName());
        if (existSubjectVo == null){
            subjectService.saveSubject(subjectVo);
            return new ModelAndView("redirect:list.do");
        }else{
            ModelAndView modelAndView = new ModelAndView("subject/update");
            SubjectOperateVo subjectOperateVo = new SubjectOperateVo();
            subjectOperateVo.setSubjectVo(subjectVo);
            subjectOperateVo.setError("学科名已经存在!");
            modelAndView.addObject("subjectOperateVo",subjectOperateVo);
            return modelAndView;
        }
    }

    /**
     * 删除学科信息
     */
    @RequestMapping(value = "delete")
    public String delete(SubjectVo subjectVo){
        subjectService.deleteSubject(subjectVo.getId());
        return "redirect:list.do";
    }
}
