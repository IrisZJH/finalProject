package com.zjh.project.handler;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Employee;
import com.zjh.project.entity.Post;
import com.zjh.project.service.DeptService;
import com.zjh.project.service.EmployeeService;
import com.zjh.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("post")
@Controller
public class PostHandler {
    @Autowired
    private DeptService deptService;
    @Autowired
    private PostService postService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("addPost")
    public String addPost(Post post,String dname, HttpSession session){
        Dept dept=deptService.getDeptBydname(dname);
        post.setDept(dept);
        postService.addPost(post);
        List<Post> postList=postService.getAll();
        session.setAttribute("postList",postList);
        return "adminpage";
    }

    @RequestMapping("lookDept")
    public String lookDept(HttpSession session){
        List<Dept> deptList=deptService.getAll();
        session.setAttribute("deptList",deptList);
        return "addPost";
    }

    @RequestMapping("getAllPost")
    public String getAllPost(HttpSession session){
        List<Post> postList=postService.getAll();
        session.setAttribute("postList",postList);
        return "showPost";
    }

    @RequestMapping("getPost")
    public String getPost(HttpSession session,Integer pid){
        System.out.println(pid+"PID");
        Post post=postService.getPostByPid(pid);
        session.setAttribute("post",post);
        return "updatePost";
    }

    @RequestMapping("updatePost.action")
    public String updatePost(HttpSession session,Post post){
        postService.updatePost(post);
        return "forward:getAllPost";
    }

    @RequestMapping("deletePost")
    public String deletePost(HttpSession session, Integer pid, ModelMap map){
        Post post=postService.getPostByPid(pid);
        List<Employee> list=employeeService.getEmployeeByPid(pid);
        if (list.size()>0){
            map.addAttribute("DPF","该部门下面有人，不能删除");
        }else {
            postService.deletePost(post);
        }
        return "forward:getAllPost";
    }


}
