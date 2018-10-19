package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("employee")
@Controller
public class EmployeeHandler {
    @Autowired
    private PostService postService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
@RequestMapping("addEmployee")
public String addEmployee(Employee employee, String pname, HttpSession session){
    Dept dept=(Dept) session.getAttribute("dept");
    Post post=(Post) session.getAttribute("post");
    Resume resume=(Resume)session.getAttribute("resume");
    Resume resume1=resumeService.getResumeByRid(resume.getRid());
    User user=resume1.getUser();

    employee.setUser(user);
    employee.setPost(post);
    employee.setDept(dept);
    employeeService.addEmployee(employee);
    user.setState(1);
    resume.setInterview(4);
    resume.setState(4);
    userService.updateState(user);
    resumeService.updateResume(resume);
    return "adminpage";
}
}
