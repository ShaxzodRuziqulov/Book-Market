package com.example.bookmarket.service.impl;

import com.example.bookmarket.domain.Order;
import com.example.bookmarket.domain.enumation.Status;
import com.example.bookmarket.domain.request.ReqOrder;
import com.example.bookmarket.repository.OrderRepository;
import com.example.bookmarket.repository.PersonalCabinetRepository;
import com.example.bookmarket.repository.ProductRepository;
import com.example.bookmarket.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PersonalCabinetRepository personalCabinetRepository;
    private final ProductRepository productRepository;
    public OrderServiceImpl(OrderRepository orderRepository, PersonalCabinetRepository personalCabinetRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.personalCabinetRepository = personalCabinetRepository;
        this.productRepository = productRepository;
    }

    public String create(ReqOrder reqOrder) {
        try {
            Order order = new Order();
            order.setPersonalCabinet(personalCabinetRepository.findById(reqOrder.getPersonalCabinet()).orElseThrow(()->new EntityNotFoundException("not found personal cabinet")));
            order.setProducts(productRepository.findById(reqOrder.getProducts()).orElseThrow(()-> new EntityNotFoundException("error products")));
            order.setStatus(Status.NEW);
            orderRepository.save(order);
            return "Save";
        } catch (Exception e) {
            e.printStackTrace();
            return "xatolik";
        }
    }

    public String update(ReqOrder reqOrder) {
        try {
            if (reqOrder.getId() != null) {
                if (orderRepository.findById(reqOrder.getId()).isPresent()) {
                    Order order = orderRepository.findById(reqOrder.getId()).get();
                    order.setPersonalCabinet(personalCabinetRepository.findById(reqOrder.getPersonalCabinet()).orElseThrow(()->new EntityNotFoundException("not found personal cabinet")));
                    order.setProducts(productRepository.findById(reqOrder.getProducts()).orElseThrow(()-> new EntityNotFoundException("error products")));
                    if (reqOrder.getStatus() != null)
                        order.setStatus(Status.valueOf(reqOrder.getStatus()));
                    orderRepository.save(order);
                    return "Save";
                } else {
                    return "id topilmadi";
                }
            } else {
                return "id kiritilmadi";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "xatolik";
        }
    }

    public List<Order> all() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> findById = orderRepository.findById(id);
        return findById.orElseGet(Order::new);
    }

    public void delete(Long id) {
        Order order = orderRepository.getReferenceById(id);
        orderRepository.delete(order);
    }


}
