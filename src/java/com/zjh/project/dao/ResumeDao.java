package com.zjh.project.dao;

import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface ResumeDao {
    public void addResume(Resume resume);
    public void updateResume(Resume resume);
    public void deleteResume(Resume resume);
    public List<Resume> getAllResume();
    public Resume getResumeByUid(int uid);
    public Resume getResumeByRid(int rid);
    public Resume looKResume();
}
