package com.zjh.project.service.impl;

import com.zjh.project.dao.EmployeeDao;
import com.zjh.project.dao.RewardAndPunishDao;
import com.zjh.project.entity.Employee;
import com.zjh.project.entity.RewardAndPunish;
import com.zjh.project.service.EmployeeService;
import com.zjh.project.service.RewardAndPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("rewardAndPunishService")
@Transactional
public class RewardAndPunishServiceImpl implements RewardAndPunishService {
    @Autowired
    private RewardAndPunishDao rewardAndPunishDao;


    @Override
    public void addRwandph(RewardAndPunish rewardAndPunish) {
        rewardAndPunishDao.addRwandph(rewardAndPunish);
    }

    @Override
    public void updateRwandph(RewardAndPunish rewardAndPunish) {
        rewardAndPunishDao.updateRwandph(rewardAndPunish);
    }

    @Override
    public void deleteRwandph(int rpid) {
        rewardAndPunishDao.deleteRwandph(rpid);
    }

    @Override
    public List<RewardAndPunish> getAll() {
        List<RewardAndPunish> rewardAndPunishes = rewardAndPunishDao.getAll();
        return rewardAndPunishes;
    }

    @Override
    public RewardAndPunish getRwandphRpid(int rpid) {
        return rewardAndPunishDao.getRwandphRpid(rpid);
    }

    @Override
    public List<RewardAndPunish> getRwandphByParam(Map<String, Object> map) {
        return rewardAndPunishDao.getRwandphByParam(map);
    }
}
