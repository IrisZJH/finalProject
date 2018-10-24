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
@RequestMapping("rewardAndPunish")
@Controller
public class RewardAndPunishHandler {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RewardAndPunishService rewardAndPunishService;

    @RequestMapping("getAllEmployeeAndaddRwandph")
    public String getAllEmployeeAndaddRwandph(HttpSession session){
        List<Employee> employeeList1=employeeService.getAll();
        List<Employee> employeeList=new ArrayList<>();
        for (int i=0;employeeList1.size()>i;i++){
            if (employeeList1.get(i).getState().equals(1)){
                employeeList.add(employeeList1.get(i));
            }
        }
        session.setAttribute("employeeList",employeeList);
        return "addrewardAndPunish";
    }
    @RequestMapping("addRwandph")
    public String addRwandph(RewardAndPunish rewardAndPunish, int eid, ModelMap map){
        Employee employee=employeeService.getEmployeeByeid(eid);
        rewardAndPunish.setEmployee(employee);
        rewardAndPunishService.addRwandph(rewardAndPunish);
        map.addAttribute("RwS","添加成功");
        return "adminpage";
    }

    @RequestMapping("getAllRP")
    public String getAllRP(HttpSession session){
        List<RewardAndPunish> rwandphList=rewardAndPunishService.getAll();
        System.out.println(rwandphList);
        session.setAttribute("rwandphList",rwandphList);
        return "showAllRP";
    }

    @RequestMapping("getRwandph")
    public String getRwandph(Integer rpid, HttpSession session){
        RewardAndPunish rwandph=rewardAndPunishService.getRwandphRpid(rpid);
        session.setAttribute("rwandph",rwandph);
        return "updateRP";
    }

    @RequestMapping("updateRwandph")
    public String updateAward(Integer eid,RewardAndPunish rwandph){
        System.out.println(eid);
        Employee employee=employeeService.getEmployeeByeid(eid);
        rwandph.setEmployee(employee);
        rewardAndPunishService.updateRwandph(rwandph);
        return "forward:getAllRP";
    }

    @RequestMapping("deleteRwandph")
    public String deleteRwandph(Integer rpid){
        System.out.println(rpid+"rpid");
        rewardAndPunishService.deleteRwandph(rpid);
        return "forward:getAllRP";
    }


}
