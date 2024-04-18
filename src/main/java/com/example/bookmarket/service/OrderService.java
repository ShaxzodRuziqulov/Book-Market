package com.example.bookmarket.service;

import com.example.bookmarket.domain.Order;
import com.example.bookmarket.domain.request.ReqOrder;

import java.util.List;

public interface OrderService {
    String create(ReqOrder reqOrder);

    String update(ReqOrder reqOrder);

    List<Order> all();

    Order findById(Long id);

    void delete(Long id);
}
