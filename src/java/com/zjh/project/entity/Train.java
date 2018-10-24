package com.zjh.project.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18221 on 2018/10/23.
 */
public class Train {
    private int tid;
    private String tname;
    private Date begintime;
    private Date endtime;
    private String content;
    private int state;
    private Set<Employee> employeeSet=new HashSet<>();

    public Train() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Train(String tname) {
        this.tname = tname;
    }
}
