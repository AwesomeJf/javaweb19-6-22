package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.DatesMapper;
import com.wzu.qunawan.pojo.Dates;
import com.wzu.qunawan.service.DatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatesServiceImpl implements DatesService {
    @Autowired
    DatesMapper datesMapper;

    @Override
    public List<Dates> selectBySchedule(int schedule) {
        return datesMapper.selectBySchedule(schedule);
    }
}
