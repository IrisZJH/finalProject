package com.zjh.project.test;


import com.zjh.project.dao.CheckDao;
import com.zjh.project.dao.RewardAndPunishDao;
import com.zjh.project.dao.TrainDao;
import com.zjh.project.entity.Checkon;
import com.zjh.project.entity.RewardAndPunish;
import com.zjh.project.entity.Train;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Test {
    @Autowired
  private TrainDao trainDao;
    @Autowired
    private RewardAndPunishDao rewardAndPunishDao;
    @Autowired
    private CheckDao checkDao;

    @org.junit.Test
    public void addTrain(){
        Train train = new Train("asd");
        trainDao.addTrain(train);
    }

    @org.junit.Test
    public void getAll(){
        List<RewardAndPunish> rwandphList=rewardAndPunishDao.getAll();
        System.out.println(rwandphList);
    }

    @org.junit.Test
    public void getCheckByEid(){
        checkDao.getCheckonByEid(3);
        System.out.println(checkDao.getCheckonByEid(3));
    }
    @org.junit.Test
    public void getCAll(){
       List<Checkon> list = checkDao.getAll();
        System.out.println(list);
    }
    @org.junit.Test
    public void getRwandphByParam(){
        Map<String, Object> paramMap2 = new HashMap<String, Object>();
        paramMap2.put("eid",2);
        paramMap2.put("month","%" + 10 + "%");
        List<RewardAndPunish> rwandphList = rewardAndPunishDao.getRwandphByParam(paramMap2);
        System.out.println(rwandphList);
    }

}
