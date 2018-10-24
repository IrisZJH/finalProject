package com.zjh.project.service.impl;

import com.zjh.project.dao.EmployeeDao;
import com.zjh.project.dao.TrainDao;
import com.zjh.project.entity.Employee;
import com.zjh.project.entity.Train;
import com.zjh.project.service.EmployeeService;
import com.zjh.project.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("trainService")
@Transactional
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;

    @Override
    public void addTrain(Train train) {
        trainDao.addTrain(train);
    }
    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public void deleteTrain(Train train) {
        trainDao.deleteTrain(train);
    }

    @Override
    public List<Train> getAll() {
        List<Train> trainList=trainDao.getAll();
        return trainList;
    }

    @Override
    public Train getTrainByeid(int eid) {
        return trainDao.getTrainByeid(eid);
    }

    @Override
    public Train getTrainByTid(int tid) {
        return trainDao.getTrainByTid(tid);
    }

    @Override
    public Train getTrainByTname(String tname) {
        return trainDao.getTrainByTname(tname);
    }

    @Override
    public List<Train> getAllByEmployee() {
        return trainDao.getAllByEmployee();
    }

}
