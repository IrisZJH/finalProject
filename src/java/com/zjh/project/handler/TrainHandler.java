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
@RequestMapping("train")
@Controller
public class TrainHandler {
    @Autowired
    private TrainService trainService;
    @Autowired
    private PostService postService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptService deptService;

    @RequestMapping("getAllEmpAndAddTrain")
    public String getAllEmployee(HttpSession session){
        List<Employee> employeeList1=employeeService.getAll();
        List<Employee> employeeList=new ArrayList<>();
        for (int i=0;employeeList1.size()>i;i++){
            if (employeeList1.get(i).getState().equals(1)&&employeeList1.get(i).getTrain()==null){
                employeeList.add(employeeList1.get(i));

            }
        }
        session.setAttribute("employeeList",employeeList);
        System.out.println("getAllEmpAndAddTrain"+employeeList);
        return "addTrain";
    }
    /*添加培训信息*/
    @RequestMapping("addTrain")
    public String addTrain(Train train,String[] eid, HttpSession session){
        System.out.println("addTrain");
        trainService.addTrain(train);
        int tid = trainService.getTrainByTname(train.getTname()).getTid();
        System.out.println(train);
        System.out.println(tid);
        Train train1=trainService.getTrainByTid(tid);
        System.out.println("train1"+train1);
        System.out.println("eid:"+Integer.parseInt(eid[0]));
        for (int i=0;i<eid.length;i++){
            Employee employee=employeeService.getEmployeeByeid(Integer.parseInt(eid[i]));
            employee.setTrain(train1);
            employeeService.updateTrain(employee);
        }
        return "adminpage";
    }
    //查看所有培训
    @RequestMapping("getAllTrain")
    public String getAllTrain(HttpSession session){
        List<Train> trainList=trainService.getAllByEmployee();
        session.setAttribute("trainList",trainList);
        return "showAllTrain";
    }
    //员工查看自己的培训信息
    @RequestMapping("getTrainFromEmp")
    public String getTrainFromEmp(HttpSession session,Employee employee){
        Employee employee1=(Employee) session.getAttribute("employee");
        Train train=trainService.getTrainByeid(employee1.getEid());
        session.setAttribute("train",train);
        return "getTrainByEmployee";
    }

//    @RequestMapping("updateT")
//    public String updateT(Integer tid){
//        Train train=trainService.getTrainByTid(tid);
//        train.setState(1);
//        trainService.updateTrain(train);
//        return "forward:getTrainFromEmp";
//    }

}
