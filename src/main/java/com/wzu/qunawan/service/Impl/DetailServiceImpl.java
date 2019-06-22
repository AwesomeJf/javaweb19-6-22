package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.DetailMapper;
import com.wzu.qunawan.pojo.Detail;
import com.wzu.qunawan.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailMapper detailMapper;

    @Override
    public Detail selectByTrip(int trip) {
        return detailMapper.selectByTrip(trip);
    }
}
