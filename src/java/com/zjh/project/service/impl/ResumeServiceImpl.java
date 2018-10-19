package com.zjh.project.service.impl;

import com.zjh.project.dao.ResumeDao;
import com.zjh.project.dao.UserDao;
import com.zjh.project.entity.Resume;
import com.zjh.project.entity.User;
import com.zjh.project.service.ResumeService;
import com.zjh.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("resumeService")
@Transactional
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;
//    public ResumeDao getResumeDao() {return resumeDao;}
//    public void setResumeDao(ResumeDao resumeDao) {this.resumeDao = resumeDao;}


    @Override
    public void addResume(Resume resume) {
        resumeDao.addResume(resume);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeDao.updateResume(resume);
    }

    @Override
    public void deleteResume(Resume resume) {
        resumeDao.deleteResume(resume);
    }

    @Override
    public List<Resume> getAllResume() {
        List<Resume> resumeList=resumeDao.getAllResume();
        return resumeList;

    }

    @Override
    public Resume getResumeByUid(int uid) {
//        Resume e4= resumeDao.getResumeByUid(25);
        return resumeDao.getResumeByUid(uid);
    }

    @Override
    public Resume getResumeByRid(int rid) {
        return resumeDao.getResumeByRid(rid);
    }

    @Override
    public Resume looKResume() {
        return resumeDao.looKResume();
    }
}
