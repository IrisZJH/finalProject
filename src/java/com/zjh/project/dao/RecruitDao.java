package com.zjh.project.dao;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface RecruitDao {
    public void addRecruit(Recruit recruit);
    public void updateRecruit(Recruit recruit);
    public void deleteRecruit(Recruit recruit);
    public List<Recruit> getAll();
    public Recruit getRecruitByReid(int reid);
    public List<Recruit> getNormalRecruit();
}
