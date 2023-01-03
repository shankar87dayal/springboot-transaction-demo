package com.javawithraushan.springboot.controller;

import com.javawithraushan.springboot.dto.OrderRequest;
import com.javawithraushan.springboot.dto.OrderResponse;
import com.javawithraushan.springboot.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
