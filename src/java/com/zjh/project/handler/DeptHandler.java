package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("dept")
@Controller
public class DeptHandler {
    @Autowired
    private DeptService deptService;
//    @Autowired
//    private PostService postService;

//增加部门
    @RequestMapping("addDept")
    public String addDept(Dept dept, HttpSession session,ModelMap map){
        Dept dept1=deptService.getDeptByname(dept.getDname());
        System.out.println(dept.getDname());
        System.out.println(dept1);
        if (dept1!=null){
            map.addAttribute("same","已有该部门不能重复添加");
        }else {
            deptService.addDept(dept);
            List<Dept> list1=deptService.getAll();
            System.out.println(list1);
            session.setAttribute("list1",list1);
        }
        return "adminpage";
    }
//获取所有部门
    @RequestMapping("getAlldept")
    public String getAlldept(HttpSession session){
        List<Dept> deptList=deptService.getAll();
        session.setAttribute("deptList",deptList);
        return "showAllDept";
    }
//查看部门职位
    @RequestMapping("getDeptInfo")
    public String getDeptInfo(String dname,HttpSession session){
        Dept dept=deptService.getDeptBydname(dname);
        session.setAttribute("dept",dept);
        return "showDeptPost";
    }
    /*删除*/
    @RequestMapping("deleteDept")
    public String deleteDept(Integer did,ModelMap map){

        Dept dept=deptService.getDeptByDId(did);
        Dept dept1=deptService.getDeptBydname(dept.getDname());
        if (dept1==null){
            System.out.println("职位是空的部门");
            deptService.deleteDept(did);
            map.addAttribute("deleteDept","部门删除成功");
        }else {
            map.addAttribute("deleteDept","部门下面有职位不能删除");
        }
        return "forward:getAlldept";
    }
//获取要修改的部门信息
    @RequestMapping("getDept")
    public String getDept(Integer did,HttpSession session){
        Dept dept=deptService.getDeptByDId(did);
        session.setAttribute("dept",dept);
        return "updateDept";
    }
//修改部门信息
    @RequestMapping("updateDept")
    public String updateDept(Dept dept){
        System.out.println(dept);
        deptService.updateDept(dept);
        return "forward:getAlldept";
    }

    @RequestMapping("selectDept")
    public Set<Post> select(HttpSession session, String dname){
        Dept dept=deptService.getDeptBydname(dname);
        return dept.getPostSet();
    }

}
