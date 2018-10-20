package com.zjh.project.dao;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface DeptDao {
    public void addDept(Dept dept);
    public void updateDept(Dept  dept);
    public void deleteDept(int did);
    public Dept getDeptBydname(String dname);
    public List<Dept> getAll();
    public Dept getDeptByUid(int did);
    public Dept getDeptByPid(int pid);
    public Dept getDeptByDId(int did);
    public Dept getDeptByname(String dname);
}
