package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.PriceMapper;
import com.wzu.qunawan.pojo.Price;
import com.wzu.qunawan.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceMapper priceMapper;

    @Override
    public float getPrice(int id) {
        return priceMapper.selectByPrimaryKey(id).getPrice();
    }

    @Override
    public List<Price> getPriceByTrip(int tripId) {
        return priceMapper.selectByTrip(tripId);
    }
}
