package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Trip;
import com.wzu.qunawan.pojo.Tripshow;

import java.util.List;

public interface TripService {
    public Trip selectByPrimaryKey(int id);
    public List<Trip> findAll();
    public List<Trip> findAllByHot();
    public List<Tripshow> selectAllByPlace(String place);
    public List<Tripshow> selectByPlaceAndCity(String city);
    public List<Tripshow> selectByTheme(String theme);
}
