package com.zjh.project.handler;

import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;
import com.zjh.project.entity.User;
import com.zjh.project.service.RecruitService;
import com.zjh.project.service.ResumeService;
import com.zjh.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    /*投递简历 State简历投递状态 4为不投递，1为已投递*/
    @RequestMapping("seedResume")
    public String appRecruit(int reid, HttpSession session, ModelMap map) {
        Recruit recruit = recruitService.getRecruitByReid(reid);
        Resume resume1 = (Resume) session.getAttribute("resume");
        if (resume1.getState().equals(1)||resume1.getState().equals(2)) {
            map.addAttribute("seedResumefail", "已经投过简历，不能重复投递");
            return "userpage";
        }else {
            resume1.setState(1);
            resume1.setReid(reid);
            resumeService.updateResume(resume1);
            map.addAttribute("success", "投递简历成功");
            return "userpage";
        }
    }
}
