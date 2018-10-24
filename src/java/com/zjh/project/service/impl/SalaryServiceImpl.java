package com.zjh.project.service.impl;

import com.zjh.project.dao.SalaryDao;
import com.zjh.project.entity.Salary;
import com.zjh.project.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("salaryService")
@Transactional
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;

    @Override
    public void addSalary(Salary salary) {
        salaryDao.addSalary(salary);
    }

    @Override
    public void updateSalary(Salary salary) {
        salaryDao.updateSalary(salary);
    }

    @Override
    public List<Salary> getByEid(int eid) {
        return salaryDao.getByEid(eid);
    }

    @Override
    public Salary getBySid(int sid) {
        return salaryDao.getBySid(sid);
    }

    @Override
    public List<Salary> getAllSalary() {
        return salaryDao.getAllSalary();
    }

    @Override
    public Salary getSalaryByEidAndMonth(Map<String, Object> map) {
        return salaryDao.getSalaryByEidAndMonth(map);
    }
}
