package com.zjh.project.entity;

import java.util.Date;

/**
 * Created by 18221 on 2018/10/24.
 */
public class Salary {
    private int sid;
    private Double basic;//基本工资
    private Double bonus;//奖金
    private Double social;//社保
    private Double punish;//奖罚
    private Double totalSal;//总金额
    private Date accountTime;//发工资时间
    private Employee employee;

    public Salary() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getSocial() {
        return social;
    }

    public void setSocial(Double social) {
        this.social = social;
    }

    public Double getPunish() {
        return punish;
    }

    public void setPunish(Double punish) {
        this.punish = punish;
    }

    public Double getTotalSal() {
        return totalSal;
    }

    public void setTotalSal(Double totalSal) {
        this.totalSal = totalSal;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sid=" + sid +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", social=" + social +
                ", punish=" + punish +
                ", totalSal=" + totalSal +
                ", accountTime=" + accountTime +
                ", employee=" + employee +
                '}';
    }
}
