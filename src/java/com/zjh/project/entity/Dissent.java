package com.zjh.project.entity;

/**
 * Created by 18221 on 2018/10/24.
 */
public class Dissent {
    private int did;
    private double money;
    private String dissent;
    private String month;
    private Employee employee;

    public Dissent() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDissent() {
        return dissent;
    }

    public void setDissent(String dissent) {
        this.dissent = dissent;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Dissent{" +
                "did=" + did +
                ", money=" + money +
                ", dissent='" + dissent + '\'' +
                ", month='" + month + '\'' +
                ", employee=" + employee +
                '}';
    }
}
