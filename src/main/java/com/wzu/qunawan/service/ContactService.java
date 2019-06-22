package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> selectByOrdersuser(int id);
    List<Contact> selectAll(int id);
    int updateByUserId(Contact contact,int id);
    int insert(Contact contact);
    Contact selectByPrimaryKey(int id);
    int updateByContactId(Contact contact);
    int deleteByPrimaryKey(int id);
    public List<Contact>selectByUser(int user);
}
