package com.zjh.project.entity;

/**
 * Created by 18221 on 2018/10/18.
 */
public class User {
    private int uid;
    private String uname;
    private String upassword;
    private Integer state;
    private Resume resume;

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public User() {
    }

    public User(int uid, String uname, String upassword, Integer state) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;

    }
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", state=" + state +
                ", resume=" + resume +
                '}';
    }
}
