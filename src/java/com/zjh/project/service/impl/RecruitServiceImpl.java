package com.zjh.project.service.impl;

import com.zjh.project.dao.RecruitDao;
import com.zjh.project.dao.ResumeDao;
import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;
import com.zjh.project.service.RecruitService;
import com.zjh.project.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("recruitService")
@Transactional
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    @Override
    public void addRecruit(Recruit recruit) {
        recruitDao.addRecruit(recruit);
    }

    @Override
    public void updateRecruit(Recruit recruit) {
        recruitDao.updateRecruit(recruit);
    }

    @Override
    public void deleteRecruit(Recruit recruit) {
        recruitDao.deleteRecruit(recruit);
    }

    @Override
    public List<Recruit> getAll() {
        return recruitDao.getAll();
    }

    @Override
    public Recruit getRecruitByReid(int reid) {
        return recruitDao.getRecruitByReid(reid);
    }

}
