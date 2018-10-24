package com.zjh.project.entity;

import java.util.Date;

/**
 * Created by 18221 on 2018/10/23.
 */
public class RewardAndPunish {
    private int rpid;
    private double money;
    private Date rptime;
    private String cause;
    private Employee employee;

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getRptime() {
        return rptime;
    }

    public void setRptime(Date rptime) {
        this.rptime = rptime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "RewardAndPunish{" +
                "rpid=" + rpid +
                ", money=" + money +
                ", rptime=" + rptime +
                ", cause='" + cause + '\'' +
                ", employee=" + employee +
                '}';
    }
}
