package com.zjh.project.handler;

import com.zjh.project.entity.*;
import com.zjh.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@RequestMapping("check")
@Controller
public class CheckHandler {
    @Autowired
    private CheckonService checkonService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RewardAndPunishService rewardAndPunishService;

    //上班签到
    @RequestMapping("addCheckon")
    public String addCheckon(HttpSession session, ModelMap map) throws ParseException {
        RewardAndPunish rewardAndPunish = new RewardAndPunish();
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String source = "9:00";//上班规定时间
        double h = 0;
        Date date = null;
        Date date1 = null;
        try {
            date = sdf.parse(source);//上班规定时间
            date1 = sdf.parse(sdf.format(new Date()));//当前打卡时间
            h = (date1.getTime() - date.getTime()) / 1000 / 3600.0;//毫秒转化成时

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Checkon> checkonList = checkonService.getCheckonByEid(employee.getEid());
        if (checkonList.size() != 0) {
            Checkon checkon = checkonList.get(checkonList.size() - 1);
            Date date2 = sdf1.parse(sdf1.format(checkon.getStarttime()));//check的年月日
            Date date3 = sdf1.parse(sdf1.format(new Date()));//当前年月日
            if (!date2.equals(date3)) {//不是今天的打卡记录则新建记录
                Checkon checkon1 = new Checkon();
                checkon1.setStarttime(new Date());
                checkon.setGowork_state("正常");
                if (0 < h && h <= 3) {
                    checkon1.setGowork_state("迟到");
                    rewardAndPunish.setRptime(new Date());
                    rewardAndPunish.setCause("迟到");
                    rewardAndPunish.setEmployee(employee);
                    rewardAndPunish.setMoney(-50);
                    System.out.println(rewardAndPunish);
                    rewardAndPunishService.addRwandph(rewardAndPunish);
                } else if (h > 3) {
                    checkon1.setGowork_state("旷工");
                    rewardAndPunish.setRptime(new Date());
                    rewardAndPunish.setCause("旷工");
                    rewardAndPunish.setEmployee(employee);
                    rewardAndPunish.setMoney(-200);
                    System.out.println(rewardAndPunish);
                    rewardAndPunishService.addRwandph(rewardAndPunish);
                }

                checkon1.setEmployee(employee);
                checkonService.addChechon(checkon1);
                Checkon checkon2 = checkonService.getCheckonByKid(checkon1.getKid());
                session.setAttribute("checkon2", checkon2);
                map.addAttribute("success", "签到成功");
            } else {
                Checkon checkon2 = checkonList.get(checkonList.size() - 1);
                session.setAttribute("checkon2", checkon2);
                map.addAttribute("defeated", "你已经打过卡了");
            }

            return "showCheck";
        }
//没有过打卡记录
        Checkon checkon = new Checkon();
        checkon.setStarttime(new Date());
        checkon.setGowork_state("正常");
        if (0 < h && h <= 3) {
            checkon.setGowork_state("迟到");
            rewardAndPunish.setRptime(new Date());
            rewardAndPunish.setCause("迟到");
            rewardAndPunish.setEmployee(employee);
            rewardAndPunish.setMoney(-50);
            System.out.println(rewardAndPunish);
            rewardAndPunishService.addRwandph(rewardAndPunish);
        }
        if (h > 3) {
            checkon.setGowork_state("旷工");
            rewardAndPunish.setRptime(new Date());
            rewardAndPunish.setCause("旷工");
            rewardAndPunish.setEmployee(employee);
            rewardAndPunish.setMoney(-200);
            System.out.println(rewardAndPunish);
            rewardAndPunishService.addRwandph(rewardAndPunish);
        }
        checkon.setEmployee(employee);
        checkonService.addChechon(checkon);
        Checkon checkon2 = checkonService.getCheckonByKid(checkon.getKid());
        session.setAttribute("checkon2", checkon2);
        map.addAttribute("success", "签到成功");
        return "showCheck";
    }

    /*下班签到*/
    @RequestMapping("updateCheckon")
    public String updateCheckon(HttpSession session, ModelMap map) throws ParseException {
        RewardAndPunish rewardAndPunish = new RewardAndPunish();
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String source = "17:00";//下班规定时间
        double h = 0;
        Date date = null;
        Date date1 = null;
        try {
            date = sdf.parse(source);
            date1 = sdf.parse(sdf.format(new Date()));
            h = (date.getTime() - date1.getTime()) / 1000 / 3600.0;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Checkon> checkonList = checkonService.getCheckonByEid(employee.getEid());
        if (checkonList.size() != 0) {
            Checkon checkon = checkonList.get(checkonList.size() - 1);
            if (checkon.getStarttime() != null && checkon.getEndtime() == null) {
                checkon.setEndtime(new Date());
                checkon.setUpwork_state("正常");
                if (0 < h && h <= 3) {
                    checkon.setUpwork_state("早退");
                    rewardAndPunish.setRptime(new Date());
                    rewardAndPunish.setCause("早退");
                    rewardAndPunish.setEmployee(employee);
                    rewardAndPunish.setMoney(-50);
                    System.out.println(rewardAndPunish);
                    rewardAndPunishService.addRwandph(rewardAndPunish);
                } else if (h > 3) {
                    checkon.setUpwork_state("旷工");
                    rewardAndPunish.setRptime(new Date());
                    rewardAndPunish.setCause("旷工");
                    rewardAndPunish.setEmployee(employee);
                    rewardAndPunish.setMoney(-200);
                    System.out.println(rewardAndPunish);
                    rewardAndPunishService.addRwandph(rewardAndPunish);
                }
                checkonService.updateCheckon(checkon);
                Checkon checkon2 = checkonService.getCheckonByKid(checkon.getKid());
                session.setAttribute("checkon2", checkon2);
            } else {
                map.addAttribute("checkon", "请先打上班卡");
            }
        }
        map.addAttribute("success", "你已经打过下班卡了");
        return "showCheck";
    }


    @RequestMapping("getAllCheckon")
    public String getAllCheckon(HttpSession session) {
        List<Checkon> list = checkonService.getAll();
        System.out.println(list);
        session.setAttribute("list",list);
        return "showAllCheck";
    }

    @RequestMapping("showEmpCheck")
    public String showEmpC(HttpSession session,Employee employee){
        Employee employee1=(Employee) session.getAttribute("employee");
        List<Checkon> checkonList= checkonService.getCheckonByEid(employee1.getEid());
        session.setAttribute("checkonList",checkonList);
        return "showEmpCheck";
    }
}
