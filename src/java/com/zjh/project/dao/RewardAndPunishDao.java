package com.zjh.project.dao;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.RewardAndPunish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface RewardAndPunishDao {
    public void addRwandph(RewardAndPunish rewardAndPunish);
    public void updateRwandph(RewardAndPunish rewardAndPunish);
    public void deleteRwandph(int  rpid);
    public List<RewardAndPunish> getAll();
    public RewardAndPunish getRwandphRpid(int rpid);
    //根据id和month查找员工的奖惩
    public List<RewardAndPunish> getRwandphByParam(Map<String,Object> map);
}

