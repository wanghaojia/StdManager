package com.biz.std.controller;

import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.util.FileUpLoadUtil;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.grade.GradeVo;
import com.biz.std.vo.student.StdSubVo;
import com.biz.std.vo.student.StudentListVo;
import com.biz.std.vo.student.StudentOperateVo;
import com.biz.std.vo.student.StudentVo;
import com.biz.std.vo.subject.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生信息的控制器
 * Created by haojia.wang on 2017/5/25.
 */
@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 学生信息列表
     */
    @RequestMapping(value = "list")
    public ModelAndView list(PageReqVo reqVo) {
        ModelAndView modelAndView = new ModelAndView("student/list");
        StudentListVo studentListVo = studentService.findStudentList(reqVo);
        modelAndView.addObject("studentListVo", studentListVo);
        return modelAndView;
    }

    /**
     * 添加学生信息页面
     */
    @RequestMapping(value = "new")
    public ModelAndView newStudent() {
        ModelAndView modelAndView = new ModelAndView("student/new");
        StudentOperateVo studentOperateVo = new StudentOperateVo();
        List<GradeVo> gradeVoList = gradeService.findGradeList();
        studentOperateVo.setGradeVoList(gradeVoList);
        modelAndView.addObject("studentOperateVo",studentOperateVo);
        return modelAndView;
    }

    /**
     * 修改学生信息页面
     */
    @RequestMapping(value = "toUpdate")
    public ModelAndView toUpdate(StudentVo studentVo) {
        ModelAndView modelAndView = new ModelAndView("student/update");
        StudentOperateVo studentOperateVo = new StudentOperateVo();
        studentVo = studentService.getStudent(studentVo.getId());
        studentOperateVo.setStudentVo(studentVo);
        List<GradeVo> gradeVoList = gradeService.findGradeList();
        studentOperateVo.setGradeVoList(gradeVoList);
        modelAndView.addObject("studentOperateVo",studentOperateVo);
        return modelAndView;
    }

    /**
     * 执行修改学生信息操作
     */
    @RequestMapping(value = "update")
    public String update(StudentVo studentVo) {
        studentService.saveStudent(studentVo);
        return "redirect:list.do";
    }

    /**
     * 执行添加学生操作
     */
    @RequestMapping(value = "save")
    public ModelAndView save(StudentVo studentVo) {
        StudentVo existStudent = studentService.getStudent(studentVo.getId());
        if (existStudent == null){
            studentService.saveStudent(studentVo);
            return new ModelAndView("redirect:list.do");
        }else{
            ModelAndView modelAndView = new ModelAndView("student/new");
            StudentOperateVo studentOperateVo = new StudentOperateVo();
            studentOperateVo.setStudentVo(studentVo);
            List<GradeVo> gradeVoList = gradeService.findGradeList();
            studentOperateVo.setGradeVoList(gradeVoList);
            studentOperateVo.setError("学生信息已经存在!");
            modelAndView.addObject("studentOperateVo",studentOperateVo);
            return modelAndView;
        }
    }

    /**
     * 学生选课
     */
    @RequestMapping(value = "toChooseSubject")
    public ModelAndView toNewSubject(StudentVo studentVo){
        ModelAndView modelAndView = new ModelAndView("student/chooseSubject");
        List<SubjectVo> subjectVoList = subjectService.findSubjectList();
        modelAndView.addObject("subjectVoList",subjectVoList);
        modelAndView.addObject("studentVo",studentVo);
        return modelAndView;
    }

    /**
     * 执行学生选课操作
     */
    @RequestMapping(value = "chooseSubject")
    public String newSubject(StdSubVo stdSubVo){
        if (stdSubVo.getScoreVoList() != null){
            studentService.saveStudent(stdSubVo);
        }
        return "redirect:list.do";
    }

    /**
     * 分数录入
     */
    @RequestMapping(value = "toUpdateScore")
    public ModelAndView toUpdateScore(StudentVo studentVo){
        ModelAndView modelAndView = new ModelAndView("student/updateScore");
        studentVo = studentService.getStudent(studentVo.getId());
        modelAndView.addObject("studentVo",studentVo);
        return modelAndView;
    }

    /**
     * 执行学生分数录入操作
     */
    @RequestMapping(value = "updateScore")
    public String updateScore(StdSubVo stdSubVo){
        studentService.saveStudent(stdSubVo);
        return "redirect:list.do";
    }

    /**
     * 删除学生信息
     */
    @RequestMapping(value = "delete")
    public String delete(StudentVo studentVo){
        studentService.deleteStudent(studentVo.getId());
        return "redirect:list.do";
    }

    /**
     * 文件上传
     */
    @RequestMapping(value = "fileUpLoad")
    @ResponseBody
    public String fileUpLoad(HttpServletRequest request){
        List<String> filePathList = FileUpLoadUtil.upload(request);
        if (filePathList.size() > 0){
            return filePathList.get(0);
        }
        return null;
    }

}
