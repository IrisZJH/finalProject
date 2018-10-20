package com.zjh.project.service;

import com.zjh.project.entity.Employee;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public List<Employee> getAll();
    public List<Employee>getEmployeeByPid(int pid);
}
