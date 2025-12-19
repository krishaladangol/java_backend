/*
package com.example.demo.controller;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.PaymentService;
import com.example.demo.dto.PaymentRequest;
import com.example.demo.model.Flight;
import com.example.demo.model.Payment;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // Allow frontend requests
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<?> addPayment(@RequestBody PaymentRequest paymentDTO) {
        System.out.println("Received payment request: " + paymentDTO);

        try {
            // Use the flightId directly from the DTO
            Long flightId = paymentDTO.getFlightId();

            // Fetch the Flight object from the database using the flightId
            Flight flight = flightService.findById(flightId);  // Assuming you have a flightService to fetch flight details

            if (flight == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Flight not found");
            }

            // Create the Payment object and set the flight
            Payment payment = new Payment(paymentDTO.getPaymentAmount(), paymentDTO.getPaymentDate(), paymentDTO.getStatus(), flight);

            // Save the Payment object
            Payment savedPayment = paymentService.savePayment(payment);
            return ResponseEntity.ok(savedPayment);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


    // Get all payments
    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payments for a specific flight
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<Payment>> getPaymentsByFlight(@PathVariable Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (!flight.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Payment> payments = flight.get().getPayments();
        return ResponseEntity.ok(payments);
    }
}*/
package com.example.demo.controller;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.PaymentService;
import com.example.demo.dto.PaymentRequest;
import com.example.demo.model.Flight;
import com.example.demo.model.Payment;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // Allow frontend requests
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PaymentService paymentService;
    /*
        @PostMapping("/add")
        public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
            System.out.println("Received payment request: " + payment);
            try {
                Payment savedPayment = paymentService.savePayment(payment);
                return ResponseEntity.ok(savedPayment);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
            }
        }*/
    @PostMapping("/add")
    public ResponseEntity<?> addPayment(@RequestBody PaymentRequest paymentDTO) {
        System.out.println("Received payment request: " + paymentDTO);

        try {
            // Use the flightId directly from the DTO
            Long flightId = paymentDTO.getFlightId();

            // Fetch the Flight object from the database using the flightId
            Flight flight = flightService.findById(flightId);  // Assuming you have a flightService to fetch flight details

            if (flight == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Flight not found");
            }

            // Create the Payment object and set the flight
            Payment payment = new Payment(paymentDTO.getPaymentAmount(), paymentDTO.getPaymentDate(), paymentDTO.getStatus(), flight);

            // Save the Payment object
            Payment savedPayment = paymentService.savePayment(payment);
            return ResponseEntity.ok(savedPayment);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


    // Get all payments
    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payments for a specific flight
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<Payment>> getPaymentsByFlight(@PathVariable Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (!flight.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Payment> payments = flight.get().getPayments();
        return ResponseEntity.ok(payments);
    }
}