package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.PositionMapper;
import com.wzu.qunawan.pojo.Position;
import com.wzu.qunawan.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;

    @Override
    public Position findByid(int id) {
        return positionMapper.selectByPrimaryKey(id);
    }
}
