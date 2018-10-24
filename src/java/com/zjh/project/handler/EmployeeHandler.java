package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
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
    @Autowired
    private DeptService deptService;
    @Autowired
    private SalaryService salaryService;
//将游客录取成员工
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
//获取所有员工
    @RequestMapping("getEmployee")
    public String getEmployee(Employee employee,HttpSession session){
        List<Employee> employeeList1=employeeService.getAll();
        List<Employee> employeeList=new ArrayList<>();
        for (int i=0;employeeList1.size()>i;i++){
            if (employeeList1.get(i).getState().equals(1)){
                employeeList.add(employeeList1.get(i));

            }
        }
        session.setAttribute("employeeList",employeeList);
        for (int i=0;employeeList.size()>i;i++){
            Dept dept=employeeList.get(i).getDept();
        }
        return "showAllEmployee";
    }
//更新员工
    @RequestMapping("updateEmployee")
    public String updateEmployee(HttpSession session,Integer eid){
        Employee employee=employeeService.getEmployeeByeid(eid);
        session.setAttribute("employee",employee);
        List<Dept> deptList=deptService.getAll();
        session.setAttribute("deptList",deptList);
        return "updateEmployee";
    }
//


    //员工调岗
    @RequestMapping("changeEmp")
    public String changeEmp(HttpSession session,Integer pid, Integer eid,String pname, ModelMap map){
        Employee employee=employeeService.getEmployeeByeid(eid);
        Post post=postService.getPostByPid(pid);
        Dept dept=post.getDept();
        employee.setDept(dept);
        employee.setPost(post);
        employeeService.updateEmployee(employee);
        map.addAttribute("updatS","修改成功");
        return "forward:getEmployee";
    }
    @RequestMapping("deleteEmployee")
    public  String changeEmp(HttpSession sesrsion,Integer eid,ModelMap map){
        Employee employee=employeeService.getEAndUByeid(eid);
        User user=employee.getUser();
        user.setState(0);
        userService.updateState(user);
        employee.setState(2);
        employeeService.updateEandU(employee);
        map.addAttribute("deleteS","开除成功");
        return "forward:getEmployee";
    }
//查看该职位下的员工
    @RequestMapping("getEmp")
    public String getEmp(Integer pid, HttpSession session,ModelMap map) {
        List<Employee> empList = employeeService.getEmployeeByPid(pid);
        session.setAttribute("empList",empList);
        return "showEmp";
    }
    //修改员工基本信息，updateEmpInfo.jsp显示基本信息，updateInfor转到修改信息页面，update更新信息
    @RequestMapping("updateEmpInfo")
    public String updateInfo(HttpSession session){
        List<Employee> employeeList1=employeeService.getAll();
        List<Employee> employeeList=new ArrayList<>();
        for (int i=0;employeeList1.size()>i;i++){
            if (employeeList1.get(i).getState().equals(1)){
                employeeList.add(employeeList1.get(i));

            }
        }
        session.setAttribute("employeeList",employeeList);
        for (int i=0;employeeList.size()>i;i++){
            Dept dept=employeeList.get(i).getDept();
        }
        return "updateEmpInfo";
    }
//
    @RequestMapping("updateInfor")
    public String updateInfor(HttpSession session,Integer eid) {
        Employee employee=employeeService.getEAndUByeid(eid);
        session.setAttribute("employee",employee);
        return "updateEmp";
    }
    @RequestMapping("update")
    public String updat(Employee employee){

        employeeService.updateEmpInfo(employee);
        return "forward:updateEmpInfo";
    }
//员工查看个人信息并选择修改
    @RequestMapping("updateOwnIfo")
    public String getOwnInfo(Employee employee){
        employeeService.updateEmpInfo(employee);
        return "employeepage";
    }
//查看自己的薪资
        @RequestMapping("getEmployeeSalary")
    public String getEmployeeSalary(HttpSession session,Employee employee){
        Employee employee1=(Employee) session.getAttribute("employee");
        List<Salary> salaryList=salaryService.getByEid(employee1.getEid());
        session.setAttribute("salaryList",salaryList);
        return "showEmployeeSalary";
    }
}
