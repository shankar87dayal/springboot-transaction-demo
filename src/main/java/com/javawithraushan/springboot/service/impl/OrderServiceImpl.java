package com.javawithraushan.springboot.service.impl;

import com.javawithraushan.springboot.dto.OrderRequest;
import com.javawithraushan.springboot.dto.OrderResponse;
import com.javawithraushan.springboot.entity.Order;
import com.javawithraushan.springboot.entity.Payment;
import com.javawithraushan.springboot.exception.PaymentException;
import com.javawithraushan.springboot.repository.OrderRepository;
import com.javawithraushan.springboot.repository.PaymentRepository;
import com.javawithraushan.springboot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order =orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment =orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");

        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);


        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
