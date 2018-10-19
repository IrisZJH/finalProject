package com.zjh.project.service;

import com.zjh.project.entity.Recruit;
import com.zjh.project.entity.Resume;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface RecruitService {
    public void addRecruit(Recruit recruit);
    public void updateRecruit(Recruit recruit);
    public void deleteRecruit(Recruit recruit);
    public List<Recruit> getAll();
    public Recruit getRecruitByReid(int reid);
    public List<Recruit> getNormalRecruit();
}
