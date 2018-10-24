package com.zjh.project.service;


import com.zjh.project.entity.Salary;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface SalaryService {
    public void addSalary(Salary salary);
    public void updateSalary(Salary salary);
    public List<Salary> getByEid(int eid);
    public Salary getBySid(int sid);
    public List<Salary> getAllSalary();
    public Salary getSalaryByEidAndMonth(Map<String,Object> map);
}
