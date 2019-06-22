package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.User;

public interface UserService {
    public boolean login(User user);
    public void insert(User user);
    public User selectByPhoneAndPassword(User user);
    User selectByPrimaryKey(int id);

    int updatePassword(String newPassword,int id);

    User selectAreaByCityId(int id);

    int updateByPrimaryKey(User user);

    int insertUserImg(byte[] img,int id);

    int updateUserImg(byte[] img,int id);

    public User selectByPhone(String phone);


}
