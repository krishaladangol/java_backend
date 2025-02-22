package com.example.demo.Service.impl;


import com.example.demo.Service.PaymentService;
import com.example.demo.model.Flight;
import com.example.demo.model.Payment;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Override
    public Payment createPayment(Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PENDING");
        return paymentRepository.save(payment);
    }
    /*
        @Override
        public Optional<Payment> getPaymentById(int paymentId) {
            return paymentRepository.findById(paymentId);
        }

        @Override
        public Payment updatePaymentStatus(int paymentId, String status) {
            return paymentRepository.findById(paymentId).map(payment -> {
                payment.setStatus(status);
                return paymentRepository.save(payment);
            }).orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
        }*/
    //added content
   /* @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
*/
    @Override
    public Payment savePayment(Payment payment) {
        Flight flight = flightRepository.findById(payment.getFlight().getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        payment.setFlight(flight);
        //payment.setPaymentDate(new Date()); // Ensure date is set
        payment.setPaymentDate(LocalDateTime.now()); // ✅ Correct way for LocalDateTime

        return paymentRepository.save(payment);
    }
    @Override
    public Payment updatePaymentStatus(int paymentId, String status) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setStatus(status);
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment not found with ID: " + paymentId);
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void deletePayment(int paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
        } else {
            throw new RuntimeException("Payment not found with ID: " + paymentId);
        }
    }
}