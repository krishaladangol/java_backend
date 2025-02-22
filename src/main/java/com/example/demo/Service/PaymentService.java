package com.example.demo.Service;


import com.example.demo.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Payment payment);
    //Optional<Payment> getPaymentById(int paymentId);
    Payment updatePaymentStatus(int paymentId, String status);
    Payment savePayment(Payment payment);
    //Payment updatePaymentStatus(int paymentId, String status);
    Payment getPaymentById(int paymentId);
    List<Payment> getAllPayments();
    void deletePayment(int paymentId);
}