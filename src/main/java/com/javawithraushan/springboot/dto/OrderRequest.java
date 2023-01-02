package com.javawithraushan.springboot.dto;

import com.javawithraushan.springboot.entity.Order;
import com.javawithraushan.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;

    private Payment payment;

}
