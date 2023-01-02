package com.javawithraushan.springboot.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }

}
