package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.UserMapper;
import com.wzu.qunawan.pojo.User;
import com.wzu.qunawan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public boolean login(User user) {
        return userMapper.checkUser(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByPhoneAndPassword(User user) {
        return userMapper.selectByPhoneAndPassword(user);
    }

    @Override
    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePassword( String newPassword,int id) {
        return userMapper.updatePassword(newPassword,id);
    }

    @Override
    public User selectAreaByCityId(int id) {
        return userMapper.selectAreaByCityId(id);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int insertUserImg(byte[] img, int id) {
        return userMapper.insertUserImg(img,id);
    }

    @Override
    public int updateUserImg(byte[] img, int id) {
        return userMapper.updateUserImg(img,id);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }
}
