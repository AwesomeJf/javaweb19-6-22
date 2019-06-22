package com.wzu.qunawan.service.Impl;

import com.wzu.qunawan.dao.OrdersMapper;
import com.wzu.qunawan.pojo.Orders;
import com.wzu.qunawan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> MyselectAll(int id) {
        return ordersMapper.selectAll(id);
    }

    @Override
    public Orders selectByUserAndSequence(int id,String orderno) {
        return ordersMapper.selectByUserAndSequence(id,orderno);
    }

    @Override
    public Orders selectByTripId(int id,String orderno) {
        return ordersMapper.selectByTripId(id,orderno);
    }

    @Override
    public void insertOrder(Orders order) {
        ordersMapper.insert(order);
    }
}
