package com.example.demo.Service.impl;

/*public class SeatServiceImpl {
}
package com.example.demo.service;*/

import com.example.demo.Service.SeatService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Booking;
import com.example.demo.model.Seat;
import com.example.demo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private  SeatRepository seatRepository;

    @Autowired
    public void SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
    @Override
    public Optional<Seat> getSeatById(int seatId) {
        return seatRepository.findById(seatId);
    }

    /* public Seat addSeat(Seat seat) {
         if (seat.isBooked()) {
             throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already booked.");
         }
         return seatRepository.save(seat);
     }*/
    @Override
    public Seat addSeat(Seat seat) {
        // Check if a seat with the same number is already booked
        Optional<Seat> existingSeat = seatRepository.findBySeatNumber(seat.getSeatNumber());

        if (existingSeat.isPresent() && existingSeat.get().getIsBooked()) {
            throw new IllegalArgumentException("Seat " + seat.getSeatNumber() + " is already booked.");
        }

        // Save the new seat
        return seatRepository.save(seat);
    }
    @Override
    public Seat updateSeat(int seatId, Seat updatedSeat) {
        return seatRepository.findById(seatId).map(seat -> {
            // seat.setFlightId(updatedSeat.getFlightId());
            seat.setSeatNumber(updatedSeat.getSeatNumber());
            seat.setIsBooked(updatedSeat.getIsBooked());
            return seatRepository.save(seat);
        }).orElseThrow(() -> new RuntimeException("Seat not found with ID: " + seatId));
    }
    @Override
    public void deleteSeat(int seatId) {
        //seatRepository.deleteById(seatId);
        seatRepository.findById(seatId).ifPresentOrElse(seat -> {
            // seat.setBooking(null); // Optional: Detach from booking
            seatRepository.delete(seat);
        }, () -> {
            throw new RuntimeException("Seat not found with ID: " + seatId);
        });

    }
}