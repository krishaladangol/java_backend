package com.example.demo.repository;

import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    // Payment findByBookingId(int bookingId);
    @Modifying
    @Query("DELETE FROM Payment p WHERE p.flight.flightId = :flightId")
    void deleteByFlightId(@Param("flightId") Long flightId);
}