package com.example.demo.model;
/*
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private double paymentAmount;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    private String status; // e.g., "Successful", "Failed"

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false) // Foreign key reference to Flight entity
    //@JsonBackReference
    @JsonIgnore // ✅ Instead of JsonBackReference, use JsonIgnore to prevent recursion issues
    private Flight flight;

    // Constructors
    public Payment() {}

    public Payment(double paymentAmount, LocalDateTime paymentDate, String status,Flight flight) {
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.flight = flight;
    }
    @Override
    public String toString() {
        return "Payment{" +
                //"paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate='" + paymentDate + '\'' +
                ", status='" + status + '\'' +
                ", flight=" + flight +
                '}';
    }
    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}*/
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private double paymentAmount;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    private String status; // e.g., "Successful", "Failed"

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false) // Foreign key reference to Flight entity
    //@JsonBackReference
    @JsonIgnore // ✅ Instead of JsonBackReference, use JsonIgnore to prevent recursion issues
    private Flight flight;

    // Constructors
    public Payment() {}

    public Payment(double paymentAmount, LocalDateTime paymentDate, String status,Flight flight) {
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.flight = flight;
    }
    @Override
    public String toString() {
        return "Payment{" +
                //"paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate='" + paymentDate + '\'' +
                ", status='" + status + '\'' +
                ", flight=" + flight +
                '}';
    }
    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}