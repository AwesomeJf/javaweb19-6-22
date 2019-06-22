package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Place;

import java.util.List;

public interface PlaceService {
    public List<Place> selectByTrip(int Trip);
}
