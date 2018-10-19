package com.zjh.project.service.impl;

import com.zjh.project.dao.DeptDao;
import com.zjh.project.dao.ResumeDao;
import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Resume;
import com.zjh.project.service.DeptService;
import com.zjh.project.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);

    }

    @Override
    public void deleteDept(int did) {
        deptDao.deleteDept(did);
    }

    @Override
    public Dept getDeptBydname(String dname) {
        Dept dept=deptDao.getDeptBydname(dname);

        return dept;
    }

    @Override
    public List<Dept> getAll() {
        List<Dept> dept=deptDao.getAll();
        return dept;
    }

    @Override
    public Dept getDeptByUid(int did) {
        return deptDao.getDeptByUid(did);

    }

    @Override
    public Dept getDeptByPid(int pid) {
        return deptDao.getDeptByPid(pid);
    }

    @Override
    public Dept getDeptByDId(int did) {
        return deptDao.getDeptByDId(did);
    }

   }
