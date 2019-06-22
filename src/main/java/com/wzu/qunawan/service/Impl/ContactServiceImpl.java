package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.ContactMapper;
import com.wzu.qunawan.pojo.Contact;
import com.wzu.qunawan.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactMapper contactMapper;


    @Override
    public List<Contact> selectByOrdersuser(int id) {
        return contactMapper.selectByOrdersuser(id);
    }

    @Override
    public List<Contact> selectAll(int id) {
        return contactMapper.selectAll(id);
    }

    @Override
    public int updateByUserId(Contact contact, int id) {
        return contactMapper.updateByUserId(contact,id);
    }

    @Override
    public int insert(Contact contact) {
        return contactMapper.insert(contact);
    }

    @Override
    public Contact selectByPrimaryKey(int id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByContactId(Contact contact) {
        return contactMapper.updateByContactId(contact);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return contactMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<Contact> selectByUser(int user) {
        return contactMapper.selectByUser(user);
    }
}
