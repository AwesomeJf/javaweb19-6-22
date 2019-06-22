package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.TripMapper;
import com.wzu.qunawan.pojo.Trip;
import com.wzu.qunawan.pojo.Tripshow;
import com.wzu.qunawan.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripMapper tripMapper;

    @Override
    public Trip selectByPrimaryKey(int id) {
        return tripMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Trip> findAll() {
        return tripMapper.selectAll();
    }

    @Override
    public List<Trip> findAllByHot() {
        return tripMapper.selectAllByHot();
    }

    @Override
    public List<Tripshow> selectAllByPlace(String place) {
        return tripMapper.selectAllByPlace(place);
    }

    @Override
    public List<Tripshow> selectByPlaceAndCity(String city) {
        return tripMapper.selectAllByPlaceAndCity(city);
    }

    @Override
    public List<Tripshow> selectByTheme(String theme) {
        return tripMapper.selectAllByTheme(theme);
    }
}
