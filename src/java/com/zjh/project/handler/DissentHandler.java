package com.zjh.project.handler;

import com.zjh.project.entity.Dissent;
import com.zjh.project.entity.Employee;
import com.zjh.project.service.DissentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("dissent")
@Controller
public class DissentHandler {
    @Autowired
   private DissentService dissentService;
    @RequestMapping("addDissent")
    public String addDissent(Dissent dissent, HttpSession session, ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        dissent.setEmployee(employee);
        System.out.println("addDissent"+employee);
        dissentService.addDissent(dissent);
        map.addAttribute("Dss","异议已成功反馈");
        return "showEmployeeSalary";
    }

    @RequestMapping("getDissent")
    public String getDissent(HttpSession session){
        List<Dissent> dissentList=dissentService.getAllDissent();
        session.setAttribute("dissentList",dissentList);
        return "showDissent";
    }
}
