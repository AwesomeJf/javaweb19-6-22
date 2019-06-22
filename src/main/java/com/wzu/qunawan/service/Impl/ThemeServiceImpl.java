package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.ThemeMapper;
import com.wzu.qunawan.pojo.Theme;
import com.wzu.qunawan.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeMapper themeMapper;

    @Override
    public List<Theme> findAll() {
        return themeMapper.selectAll();
    }

    @Override
    public List<Theme> findByTrip(int trip) {
        return themeMapper.selectByTrip(trip);
    }
}
