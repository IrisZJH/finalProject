package com.zjh.project.dao;

import com.zjh.project.entity.Dissent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/24.
 */
@Repository
public interface DissentDao {
    public void addDissent(Dissent dissent);
    public List<Dissent> getAllDissent();
}
