package com.example.demo.controller;



import com.example.demo.model.Seat;
import com.example.demo.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // 1. Get all seats
    @GetMapping("/list")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 2. Get a seat by ID
    @GetMapping("/list/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable("id") int seatId) {
        Optional<Seat> seat = seatService.getSeatById(seatId);
        return seat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/add")
    public ResponseEntity<?> addSeat(@RequestBody Seat seat) {
        try {
            Seat createdSeat = seatService.addSeat(seat);
            return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable("id") int seatId, @RequestBody Seat updatedSeat) {
        try {
            Seat updated = seatService.updateSeat(seatId, updatedSeat);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")

    public ResponseEntity<String> deleteSeat(@PathVariable("id") int seatId) {
        try {
            seatService.deleteSeat(seatId);
            return ResponseEntity.ok("Seat deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}