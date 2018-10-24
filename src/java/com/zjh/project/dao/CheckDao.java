package com.zjh.project.dao;

import com.zjh.project.entity.Checkon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface CheckDao {
    public void addChechon(Checkon checkon);
    public void updateCheckon(Checkon checkon);
    public void deleteCheckon(Checkon checkon);
    public List<Checkon> getAll();
    public List<Checkon> getCheckonByEid(int Eid);
    public Checkon getCheckonByKid(int kid);
    public List<Checkon> getCheckonByParam(Map<String,Object> map);
}
