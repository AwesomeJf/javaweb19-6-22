package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.TrafficMapper;
import com.wzu.qunawan.pojo.Traffic;
import com.wzu.qunawan.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficServiceImpl implements TrafficService {
    @Autowired
    TrafficMapper trafficMapper;

    @Override
    public Traffic selectByTrip(int trip) {
        return trafficMapper.selectByTrip(trip);
    }
}
