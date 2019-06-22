package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Price;

import java.util.List;

public interface PriceService {
    public float getPrice(int id);
    public List<Price> getPriceByTrip(int tripId);

}
