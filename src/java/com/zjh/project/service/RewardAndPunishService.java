package com.zjh.project.service;

import com.zjh.project.entity.RewardAndPunish;
import com.zjh.project.entity.Train;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface RewardAndPunishService {
    public void addRwandph(RewardAndPunish rewardAndPunish);
    public void updateRwandph(RewardAndPunish rewardAndPunish);
    public void deleteRwandph(int  rpid);
    public List<RewardAndPunish> getAll();
    public RewardAndPunish getRwandphRpid(int rpid);
}
