package com.zjh.project.handler;

import com.zjh.project.entity.Checkon;
import com.zjh.project.entity.Employee;
import com.zjh.project.entity.RewardAndPunish;
import com.zjh.project.entity.Salary;
import com.zjh.project.service.CheckonService;
import com.zjh.project.service.EmployeeService;
import com.zjh.project.service.RewardAndPunishService;
import com.zjh.project.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("salary")
@Controller
public class SalaryHandler {
    @Autowired
    private CheckonService checkonService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RewardAndPunishService rewardAndPunishService;
    @Autowired
    private SalaryService salaryService;

    @RequestMapping("addSalary")
    public String addSalary(HttpSession session, ModelMap map, Integer eid, Double basic, Double bonus, String month){
        Employee employee=employeeService.getEmployeeByeid(eid);
        SimpleDateFormat sdf = new SimpleDateFormat("dd");//天数
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");//年月
        Date date=new Date();
        String date1=sdf.format(date);//几号，定义10号发工资
        String month1=sdf1.format(date);
        Map<String,Object> paramMap1=new HashMap<String,Object>();
        paramMap1.put("eid",eid);
        paramMap1.put("date","%"+month1+"%");
        if (date1.equals("24")){
            Salary salary1=salaryService.getSalaryByEidAndMonth(paramMap1);
            if(salary1==null) {
                Map<String, Object> paramMap2 = new HashMap<String, Object>();
                paramMap2.put("eid",eid);
                paramMap2.put("month","%" + month + "%");
                System.out.println("查询奖惩条件:"+eid+month);
                List<Checkon> checkonList = checkonService.getCheckonByParam(paramMap2);
               System.out.println(checkonList.size()+"考勤天数");
                List<RewardAndPunish> rwandphList = rewardAndPunishService.getRwandphByParam(paramMap2);
                System.out.println(rwandphList+"奖惩条数");
                //一天工资
                double avg =Math.round(basic/22.0);//取到小数点后一位
                //奖惩金额
                double rwandphMoney=0;
                int day = checkonList.size()+1;
                double bSalary = avg*day;
                System.out.println("basic"+bSalary);
                Salary salary = new Salary();
                salary.setBasic(bSalary);//基本工资，按天数算

                if ( rwandphList!= null) {
                    for (RewardAndPunish rwandph : rwandphList) {
                        rwandphMoney +=rwandph.getMoney();

                    }
                    salary.setPunish(rwandphMoney);
                }
                //奖金
                salary.setBonus(bonus);
                //社保
                salary.setSocial(-200.0);
                salary.setTotalSal(salary.getBasic() + salary.getBonus() + salary.getPunish() + salary.getSocial());
                salary.setAccountTime(new Date());
                salary.setEmployee(employee);
                System.out.println("totslsalary"+salary);
                salaryService.addSalary(salary);
                Salary salary2= salaryService.getBySid(salary.getSid());
                session.setAttribute("salary2" ,salary2);
                map.addAttribute("account","工资发放成功");
            }else {
                Salary salary2= salaryService.getSalaryByEidAndMonth(paramMap1);
                session.setAttribute("salary2" ,salary2);
                map.addAttribute("resal","这个月已经发放过了");
            }
        }else {
            map.addAttribute("sal","今天不是工资发放日");
        }

        return "showSalary";
    }

    @RequestMapping("getAllEmployeetoSalary")
    public String getAllSAndE(HttpSession session){
        List<Employee> employeeList1=employeeService.getAll();
        List<Employee> employeeList=new ArrayList<>();
        for (int i=0;employeeList1.size()>i;i++){
            if (employeeList1.get(i).getState().equals(1)){
                employeeList.add(employeeList1.get(i));

            }
        }
        session.setAttribute("employeeList",employeeList);
        return "addSalary";
    }

    @RequestMapping("getAll")
    public String getAll(HttpSession session){
        List<Salary> salaryList=salaryService.getAllSalary();
        session.setAttribute("salaryList",salaryList);
        System.out.println("getAll"+salaryList);
        return "showAllSalary";
    }
}
