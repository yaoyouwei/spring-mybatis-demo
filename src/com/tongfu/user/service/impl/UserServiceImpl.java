package com.tongfu.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.tongfu.user.entity.User;
import com.tongfu.user.mapper.UserMapper;
import com.tongfu.user.service.IUserService;
@Component
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    
    public UserMapper getUserDao() {
        return userMapper;
    }
    public void setUserDao(UserMapper userDao) {
        this.userMapper = userDao;
    }


    @Override
    public User getUser(User user) {
        
        return userMapper.getUser(user);
    }
    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
