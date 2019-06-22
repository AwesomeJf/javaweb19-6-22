package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.PlaceMapper;
import com.wzu.qunawan.pojo.Place;
import com.wzu.qunawan.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceMapper placeMapper;

    @Override
    public List<Place> selectByTrip(int Trip) {
        return placeMapper.selectByTrip(Trip);
    }
}
