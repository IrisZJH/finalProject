package com.zjh.project.service.impl;

import com.zjh.project.dao.UserDao;
import com.zjh.project.entity.User;
import com.zjh.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByNameAndPwd(User user) {
        return userDao.getUserByNameAndPwd(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User userInfo(int uid) {
        return userDao.userInfo(uid);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public void updateState(User user) {
        userDao.updateState(user);
    }
}
