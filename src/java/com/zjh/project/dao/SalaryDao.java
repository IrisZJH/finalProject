package com.zjh.project.dao;
import com.zjh.project.entity.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface SalaryDao {
    public void addSalary(Salary salary);
    public void updateSalary(Salary salary);
    public List<Salary> getByEid(int eid);
    public Salary getBySid(int sid);
    public List<Salary> getAllSalary();
    public Salary getSalaryByEidAndMonth(Map<String,Object> map);
}
