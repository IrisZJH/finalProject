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
                System.out.println("user");
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
                return "regist";
            }
        }
}
