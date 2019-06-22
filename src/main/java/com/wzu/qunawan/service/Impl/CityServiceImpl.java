package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.CityMapper;
import com.wzu.qunawan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public String findCity(int id) {
        return cityMapper.selectByPrimaryKey(id).getName();
    }
}
