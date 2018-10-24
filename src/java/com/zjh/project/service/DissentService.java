package com.zjh.project.service;


import com.zjh.project.entity.Dissent;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface DissentService {
    public void addDissent(Dissent dissent);
    public List<Dissent> getAllDissent();
}
