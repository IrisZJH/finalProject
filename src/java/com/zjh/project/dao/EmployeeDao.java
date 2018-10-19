package com.zjh.project.dao;

import com.zjh.project.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/19.
 */
@Repository
public interface EmployeeDao {
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public List<Employee> getAll();
}
