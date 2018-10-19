package com.zjh.project.dao;

import com.zjh.project.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface UserDao {
    public User getUserByNameAndPwd(User user);
    public void addUser(User user);
    public User userInfo(int uid);
    public User getUserByUserName(String userName);
    public void updateState(User user);
}
