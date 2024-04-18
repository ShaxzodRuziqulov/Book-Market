package com.example.bookmarket.web.rest;

import com.example.bookmarket.domain.Order;
import com.example.bookmarket.domain.request.ReqOrder;
import com.example.bookmarket.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqOrder reqOrder) {
        String config = orderService.create(reqOrder);
        return ResponseEntity.ok(config);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqOrder reqOrder) {
        String config = orderService.update(reqOrder);
        return ResponseEntity.ok(config);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        List<Order> findByAll = orderService.all();
        return ResponseEntity.ok(findByAll);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> all(@PathVariable Long id) {
        Order findById = orderService.findById(id);
        return ResponseEntity.ok(findById);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Delete");
    }
}
