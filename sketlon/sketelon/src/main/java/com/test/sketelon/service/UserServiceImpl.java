package com.test.sketelon.service;

import com.test.sketelon.bean.User;
import com.test.sketelon.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service(value="UserService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public String getUser() {
        return userMapper.selectByPrimaryKey(1).getUsername();
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
        int i=1/0;
    }
}
