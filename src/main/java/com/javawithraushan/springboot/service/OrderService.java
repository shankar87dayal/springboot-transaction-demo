package com.javawithraushan.springboot.service;

import com.javawithraushan.springboot.dto.OrderRequest;
import com.javawithraushan.springboot.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
