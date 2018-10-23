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


}
