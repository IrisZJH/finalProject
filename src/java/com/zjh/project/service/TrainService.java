package com.zjh.project.service;

import com.zjh.project.entity.Employee;
import com.zjh.project.entity.Train;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface TrainService {
    public void addTrain(Train train);
    public void updateTrain(Train train);
    public void deleteTrain(Train train);
    public List<Train> getAll();
    public Train getTrainByeid(int eid);
    public Train getTrainByTid(int tid);
    public Train getTrainByTname(String tname);
    public List<Train> getAllByEmployee();
}
