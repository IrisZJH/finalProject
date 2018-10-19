package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("user")
@Controller
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private PostService postService;
    @Autowired
    RecruitService recruitService;


    @RequestMapping("login")
    public String login(User user, HttpSession session, ModelMap map) {
        System.out.println(user);
        User user1 = userService.getUserByNameAndPwd(user);
        System.out.println(user1);
        if (user1 != null) {
            if (user1.getState()==0) {
                User user2=userService.userInfo(user1.getUid());
                Resume resume=resumeService.getResumeByUid(user1.getUid());
                session.setAttribute("resume",resume);
                session.setAttribute("user",user1);
                System.out.println("user登陆成功");
                return "userpage";
            }
            if(user1.getState()==1){
                session.setAttribute("user",user1);
//                Employee employee=employeeService.getEmployeeByuid(user1.getUid());
//                session.setAttribute("employee",employee);
                System.out.println("employee");
                return "employeepage";
            }
            if (user1.getState()==2){
                List<Dept> deptList=deptService.getAll();
                session.setAttribute("deptList",deptList);

                List<Post> postList=postService.getAll();
                session.setAttribute("postList",postList);

                List<Recruit> recruitList=recruitService.getAll();
                session.setAttribute("recruitList",recruitList);

//                List<Employee> employeeList1=employeeService.getAll();
//                List<Employee> employeeList=new ArrayList<>();
//                for (int i=0;employeeList1.size()>i;i++){
//                    if (employeeList1.get(i).getState().equals(1)){
//                        employeeList.add(employeeList1.get(i));
//
//                    }
//                }
//                session.setAttribute("employeeList",employeeList);
                System.out.println("admin");
                return "adminpage";
            }
        }
        map.addAttribute("error","用户名或者密码错误");
        return "index";
    }

    @RequestMapping("register")
    public String register(User user,HttpSession session,ModelMap map) {
            User user1 =  userService.getUserByUserName(user.getUname());
            if(user1==null) {
                userService.addUser(user);
                map.addAttribute("str","注册成功");
                return "index";
            }else {
                map.addAttribute("str","用户名已存在");
                return "register";
            }
        }

    /*通知面试 Interview 4 没通知，1为通知 2为游客已查看通知*/
    @RequestMapping("informinterview")
    public String Informinterview(Integer rid,HttpSession session,ModelMap map){
        Resume resume= resumeService.getResumeByRid(rid);
        if(resume.getInterview()==4){
            resume.setInterview(1);
            resume.setState(2);
            System.out.println(resume);
            resumeService.updateResume(resume);
            map.addAttribute("Tinform","通知成功");
        }else {
            map.addAttribute("Finform","您已经通知过了");
        }
        return"adminpage";
    }
    /*游客查看面试信息*/
    @RequestMapping("lookInterview")
    public String lookInterview(User user,HttpSession session,ModelMap map){
        User user1=(User)session.getAttribute("user");
        /* User user3=new User();*/
        System.out.println("lookInterview,user1:"+user1);
        Resume resume4= resumeService.getResumeByUid(user1.getUid());
        System.out.println("lookInterview"+resume4);
        if (resume4==null){
            map.addAttribute("createResum","先创建简历。。");
            return "userpage";
        }
        User user2=userService.userInfo(user1.getUid());
        System.out.println("lookInterview,user2"+user2);
        Resume resume=user2.getResume();
        System.out.println("lookInterview,resum"+resume);

        if (resume.getInterview()==1){
            System.out.println(resume.getRid());
            Resume resume1=resumeService.getResumeByRid(resume.getRid());
            System.out.println(resume1);
            Recruit recruit=resume1.getRecruit();
            System.out.println("resum:"+recruit);
            Recruit recruit1=recruitService.getRecruitByReid(recruit.getReid());
            System.out.println("recruit2"+recruit1);
            Post post=recruit1.getPost();
            recruit.setPost(post);
            session.setAttribute("recruit",recruit);
        }
        return "lookInterview";
    }
    /*游客确定面试*/
    @RequestMapping("confirmInterview")
    public String confirmRecruit(HttpSession session,ModelMap map){
        User user1=(User)session.getAttribute("user");
        User user2=userService.userInfo(user1.getUid());
        Resume resume=user2.getResume();
        if (resume.getInterview()==1){
            resume.setInterview(2);
            resumeService.updateResume(resume);
            map.addAttribute("s_confirm","确认面试成功");
        }else {
            map.addAttribute("f_confirm","已经确认过本次面试");
        }
        return "userpage";
    }
}
