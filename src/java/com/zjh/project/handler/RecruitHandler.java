package com.zjh.project.handler;

import com.zjh.project.entity.Post;
import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;
import com.zjh.project.entity.User;
import com.zjh.project.service.PostService;
import com.zjh.project.service.RecruitService;
import com.zjh.project.service.ResumeService;
import com.zjh.project.service.UserService;
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

//管理员添加招聘信息
    @RequestMapping("addRecruit")
    public String addRecruit(Recruit recruit, Integer pid, HttpSession session) {
        System.out.println("addRecruit");
        List<Post> postList=postService.getAll();
        System.out.println("addRecruit"+postList);
        session.setAttribute("postList",postList);
        Post post =postService.getPostByPid(pid);
        recruit.setPost(post);
        recruit.setGrantTime(new Date(System.currentTimeMillis()));
        recruitService.addRecruit(recruit);
        return "adminpage";
    }
    @RequestMapping("showRecruit")
    public String lookRecruit(HttpSession session,User user,ModelMap map) {
        User user1=(User)session.getAttribute("user");
        Resume resume4= resumeService.getResumeByUid(user1.getUid());
        if (resume4==null){
            map.addAttribute("createResume","先创建简历。。");
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
}
