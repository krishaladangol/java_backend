package com.example.demo.Service;

import com.example.demo.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(int seatId);
    Seat addSeat(Seat seat);
    //Seat addSeat(int seatId,int bookingId);
    Seat updateSeat(int seatId, Seat updatedSeat);
    void deleteSeat(int seatId);
}