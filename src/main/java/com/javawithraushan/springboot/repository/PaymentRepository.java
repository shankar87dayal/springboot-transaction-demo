package com.javawithraushan.springboot.repository;

import com.javawithraushan.springboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
