package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.CityMapper;
import com.wzu.qunawan.pojo.Areas;
import com.wzu.qunawan.pojo.City;
import com.wzu.qunawan.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public List<Areas> selectAreas() {
        return cityMapper.selectAreas();
    }

    @Override
    public List<City> selectProvince() {
        return cityMapper.selectProvince();
    }

    @Override
    public List<City> selectCity(int id) {
        return cityMapper.selectCity(id);
    }
}
