package com.javawithraushan.springboot.repository;

import com.javawithraushan.springboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
