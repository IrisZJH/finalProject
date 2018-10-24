package com.zjh.project.dao;

import com.zjh.project.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/19.
 */
@Repository
public interface EmployeeDao {
    //录取员工
    public void addEmployee(Employee employee);
    //更新员工（调岗）
    public void updateEmployee(Employee employee);
    //开除员工，同时要更新员工表（2）和游客表（0）的state
    public void deleteEmployee(Employee employee);
    //    更新员工表和游客表的state
    public void updateEandU(Employee employee);
    public Employee getEAndUByeid(int eid);
    public List<Employee> getAll();
    public List<Employee>getEmployeeByPid(int pid);
    public Employee getEmployeeByeid(int eid);
//    修改员工基本信息
    public void updateEmpInfo(Employee employee);
//添加培训
    public void updateTrain(Employee employee);
    //登陆时获取员工信息
    public Employee getEmployeeByuid(int uid);

}
