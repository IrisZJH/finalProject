package com.zjh.project.service;

import com.zjh.project.entity.User;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface UserService {
    public User getUserByNameAndPwd(User user);
    public void addUser(User user);
    public User userInfo(int uid);
    public User getUserByUserName(String userName);
    public void updateState(User user);
}
