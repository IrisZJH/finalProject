package com.zjh.project.service.impl;

import com.zjh.project.dao.DissentDao;
import com.zjh.project.entity.Dissent;
import com.zjh.project.service.DissentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by 18221 on 2018/10/18.
 */
@Service("dissentService")
@Transactional
public class DissentServiceImpl implements DissentService {
    @Autowired
    private DissentDao dissentDao;

    @Override
    public void addDissent(Dissent dissent) {
        dissentDao.addDissent(dissent);
    }

    @Override
    public List<Dissent> getAllDissent() {
        return dissentDao.getAllDissent();
    }
}
