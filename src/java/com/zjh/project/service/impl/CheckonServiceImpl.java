package com.zjh.project.service.impl;

import com.zjh.project.dao.CheckDao;
import com.zjh.project.dao.EmployeeDao;
import com.zjh.project.entity.Checkon;
import com.zjh.project.entity.Employee;
import com.zjh.project.service.CheckonService;
import com.zjh.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("checkService")
@Transactional
public class CheckonServiceImpl implements CheckonService {
    @Autowired
    private CheckDao checkDao;

    @Override
    public void addChechon(Checkon checkon) {
        checkDao.addChechon(checkon);
    }

    @Override
    public void updateCheckon(Checkon checkon) {
        checkDao.updateCheckon(checkon);
    }

    @Override
    public void deleteCheckon(Checkon checkon) {
        checkDao.deleteCheckon(checkon);
    }

    @Override
    public List<Checkon> getAll() {
        return checkDao.getAll();
    }

    @Override
    public List<Checkon> getCheckonByEid(int Eid) {
        return checkDao.getCheckonByEid(Eid);
    }

    @Override
    public Checkon getCheckonByKid(int kid) {
        return checkDao.getCheckonByKid(kid);
    }

    @Override
    public List<Checkon> getCheckonByParam(Map<String, Object> map) {
        return checkDao.getCheckonByParam(map);
    }
}
