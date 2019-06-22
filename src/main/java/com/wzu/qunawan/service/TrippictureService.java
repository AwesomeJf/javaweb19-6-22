package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Trippicture;

import java.util.List;

public interface TrippictureService {

    public Trippicture findByid(int id);
    public List<Trippicture> findByTrip(int tripId);
}
