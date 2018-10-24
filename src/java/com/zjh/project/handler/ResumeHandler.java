package com.zjh.project.handler;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;
import com.zjh.project.entity.User;
import com.zjh.project.service.DeptService;
import com.zjh.project.service.RecruitService;
import com.zjh.project.service.ResumeService;
import com.zjh.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("resume")
@Controller
public class ResumeHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private DeptService deptService;

//新建简历，state=4,1投递，2管理员已查看通知面试，不录用则返回4，录用了还是2;
    @RequestMapping("addResume")
    public String addResume(Resume resume, HttpSession session) {
        User user = (User) session.getAttribute("user");
        resume.setUser(user);
        Resume resume1 = resumeService.getResumeByUid(user.getUid());
        if (resume1 == null) {
            resumeService.addResume(resume);
            resume1 = resumeService.getResumeByUid(user.getUid());
        }
        session.setAttribute("resume", resume1);
        User user1 = userService.userInfo(user.getUid());
        session.setAttribute("user", user1);
        return "userpage";
    }
    /*投递简历 State简历投递状态 4为没投递，1为已投递*/
    @RequestMapping("seedResume")
    public String seedRecruit(int reid, HttpSession session, ModelMap map) {
        System.out.println("seedResume:"+reid);
        Recruit recruit = recruitService.getRecruitByReid(reid);
        Resume resume1 = (Resume) session.getAttribute("resume");
        if (resume1.getState().equals(1)||resume1.getState().equals(2)) {
            map.addAttribute("seedResumefail", "已经投过简历，不能重复投递");
            return "userpage";
        }else {
            Dept dept = deptService.getDeptByPid(recruit.getPost().getPid());
            System.out.println("seedResum:"+dept);
            recruit.getPost().setDept(dept);
            resume1.setPost(recruit.getPost());
            resume1.setState(1);
            resume1.setReid(reid);
            resume1.setPid(recruit.getPost().getPid());
            resumeService.updateResume(resume1);
            System.out.println("投递简历后"+resume1);
            map.addAttribute("success", "投递简历成功");
            return "userpage";
        }

    }
    /*查看游客已投简历state=1*/
    @RequestMapping("showResume")
    public String lookResume(HttpSession session) {
        List<Resume> resumeList =resumeService.getAllResume();
        List<Resume> resumes=new ArrayList<>();
        for(int i = 0; resumeList.size()>i; i++) {
            if (resumeList.get(i).getState()==1) {
               int reid =  resumeList.get(i).getRecruit().getReid();
                System.out.println(reid);
                Dept dept =deptService.getDeptByDId( recruitService.getRecruitByReid(reid).getDept().getDid());
                System.out.println(dept);
                resumeList.get(i).getPost().setDept(dept);
                resumes.add(resumeList.get(i));
            }
        }
        System.out.println("showResume"+resumeList);
        session.setAttribute("resumes",resumes);
        System.out.println("showResume"+resumes);
        return "showResume";
    }
}
