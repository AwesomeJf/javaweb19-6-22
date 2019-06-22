package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Areas;
import com.wzu.qunawan.pojo.City;

import java.util.List;

public interface AreaService {
    List<Areas> selectAreas();
    List<City> selectProvince();
    List<City> selectCity(int id);
}
