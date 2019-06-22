package com.wzu.qunawan.service;


import com.wzu.qunawan.pojo.Orders;


import java.util.List;

public interface OrderService {
    List<Orders> MyselectAll(int id);
    Orders selectByUserAndSequence(int id,String orderno);
    Orders selectByTripId(int id,String orderno);
    void insertOrder(Orders order);
}
