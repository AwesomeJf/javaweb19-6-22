package com.wzu.qunawan.service;

import com.wzu.qunawan.pojo.Dates;

import java.util.List;

public interface DatesService {
    public List<Dates> selectBySchedule(int schedule);
}
