package com.zjh.project.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18221 on 2018/10/18.
 */
public class Recruit {
    private int reid;
    private String name;
    private String address;
    private Date grantTime;
    private String description;
    private Integer state;
    private Dept dept;
    private Post post;
    private Set<Resume> resumeSet=new HashSet<>();

    public Set<Resume> getResumeSet() {
        return resumeSet;
    }

    public void setResumeSet(Set<Resume> resumeSet) {
        this.resumeSet = resumeSet;
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public Recruit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(Date grantTime) {
        this.grantTime = grantTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "reid=" + reid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", grantTime=" + grantTime +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", dept=" + dept +
                ", post=" + post +
                ", resumeSet=" + resumeSet +
                '}';
    }
}
