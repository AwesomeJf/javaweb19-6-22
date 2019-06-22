package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Theme;

import java.util.List;

public interface ThemeService {
    public List<Theme> findAll();
    public List<Theme> findByTrip(int Trip);
}
