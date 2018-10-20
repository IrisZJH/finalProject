package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("recruit")
@Controller
public class RecruitHandler {
    @Autowired
    private PostService postService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private DeptService deptService;

//管理员添加招聘信息
    @RequestMapping("addRecruit")
    public String addRecruit(Recruit recruit, Integer pid,HttpSession session) {
        System.out.println("addRecruit");
        List<Post> postList=postService.getAll();
        System.out.println("addRecruit"+postList);
        session.setAttribute("postList",postList);
        Post post =postService.getPostByPid(pid);
        Dept dept = deptService.getDeptByPid(pid);
        recruit.setPost(post);
        recruit.setDept(dept);
        recruit.setGrantTime(new Date(System.currentTimeMillis()));
        recruitService.addRecruit(recruit);
        return "adminpage";
    }
    //游客查看招聘信息，如果没有简历则提示创建简历,recruit-state=0/1(1为已删除)
    @RequestMapping("showRecruit")
    public String lookRecruit(HttpSession session,User user,ModelMap map) {
        User user1=(User)session.getAttribute("user");
        System.out.println("showRecruit"+user1);
        Resume resume4= resumeService.getResumeByUid(user1.getUid());
        if (resume4==null){
            map.addAttribute("createResume","还没有简历，请先创建简历");
            return "userpage";
        }
        List<Recruit> recruitList1 = recruitService.getAll();
        List<Recruit> recruitList=new ArrayList<>();
        for (int i=0;recruitList1.size()>i;i++){
            if (recruitList1.get(i).getState()==0){
                recruitList.add(recruitList1.get(i));
            }
        }
        session.setAttribute("recruitList", recruitList);
        List<Post> postList = postService.getAll();
        session.setAttribute("postList", postList);
        return "showRecruit";
    }

    /*查看游客已参加面试*/
    @RequestMapping("showJoinInterview")
    public String joinResume(HttpSession session) {
        List<Resume> resumeList =resumeService.getAllResume();
        List<Resume> resumes=new ArrayList<>();
        for(int i = 0; resumeList.size()>i; i++) {
            if (resumeList.get(i).getState()==2 && resumeList.get(i).getInterview()==2) {
                resumes.add(resumeList.get(i));
            }
        }
        session.setAttribute("resumes", resumes);
        return "showJoinInterview";
    }
    /*录用*/
    @RequestMapping("hire")
    public String Hire(int rid,HttpSession session){
        Resume resume=resumeService.getResumeByRid(rid);
        session.setAttribute("resume",resume);
        Recruit recruit=resume.getRecruit();
        Recruit recruit1=recruitService.getRecruitByReid(recruit.getReid());
        Post post=recruit1.getPost();
        session.setAttribute("post",post);
        Post post1=postService.getPostByPid(post.getPid());
        Dept dept=post1.getDept();
        session.setAttribute("dept",dept);
        return "addEmployee";
    }
    /*放弃*/
    @RequestMapping("giveUp")
    public String giveUp(int rid,HttpSession session){
        Resume resume=resumeService.getResumeByRid(rid);
        resume.setInterview(4);
        resume.setState(4);
        resumeService.updateResume(resume);
        return "adminpage";
    }
    //state=0，有效
    @RequestMapping("getNormalRecruit")
    public String getAllRecruit(HttpSession session){
        List<Recruit> recruitList=recruitService.getAll();
        session.setAttribute("recruitList",recruitList);
        return "showNormalRecruit";
    }
    //state=1,删除
    @RequestMapping("deleteRecruit")
    public String updateRecruit(Integer reid, ModelMap map){
        Recruit recruit=recruitService.getRecruitByReid(reid);
        recruit.setState(1);
        recruitService.updateRecruit(recruit);
        map.addAttribute("deleteRecruit","删除成功");
        return "forward：getNormalRecruit";
    }
}
