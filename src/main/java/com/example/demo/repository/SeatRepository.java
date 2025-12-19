package com.example.demo.repository;

import com.example.demo.model.FlightInfo;
import com.example.demo.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //List<Seat> findByFlight(FlightInfo flight);
    //Optional<Seat> findBySeatNumberAndFlight(String seatNumber, Flightinfo flight);
    Optional<Seat> findBySeatNumber(String seatNumber);
}