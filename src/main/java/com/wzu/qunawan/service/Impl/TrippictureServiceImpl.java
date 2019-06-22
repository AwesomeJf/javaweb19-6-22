package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.TrippictureMapper;
import com.wzu.qunawan.pojo.Trippicture;
import com.wzu.qunawan.service.TrippictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrippictureServiceImpl implements TrippictureService {
    @Autowired
    TrippictureMapper trippictureMapper;
    @Override
    public Trippicture findByid(int id) {
        return trippictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Trippicture> findByTrip(int tripId) {
        return trippictureMapper.selectByTrip(tripId);
    }
}
