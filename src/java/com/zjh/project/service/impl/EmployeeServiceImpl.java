package com.zjh.project.service.impl;

import com.zjh.project.dao.EmployeeDao;
import com.zjh.project.entity.Employee;
import com.zjh.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee>getEmployeeByPid(int pid){
        return employeeDao.getEmployeeByPid(pid);
    }

    @Override
    public Employee getEmployeeByeid(int eid) {
        return employeeDao.getEmployeeByeid(eid);
    }

    @Override
    public void updateEandU(Employee employee) {
        employeeDao.updateEandU(employee);
    }

    @Override
    public Employee getEAndUByeid(int eid) {
        return employeeDao.getEAndUByeid(eid);
    }

    @Override
    public void updateEmpInfo(Employee employee) {
        employeeDao.updateEmpInfo(employee);
    }

    @Override
    public void updateTrain(Employee employee) {
        employeeDao.updateTrain(employee);
    }

    @Override
    public Employee getEmployeeByuid(int uid) {
        return employeeDao.getEmployeeByuid(uid);
    }


}
