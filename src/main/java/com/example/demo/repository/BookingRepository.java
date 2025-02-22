package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Flight;
import com.example.demo.model.User;
//import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.flight.flightId = :flightId")
    boolean existsByFlightId(@Param("flightId") Long flightId);
    List<Booking> findByFlight(Flight flight);
    //for reading the booking detail with flight detail ViewBooking
    @Query("SELECT b FROM Booking b JOIN FETCH b.flight") // Ensures flight details are included
    List<Booking> findAllWithFlights();
    //deleteing booking along with flight in ViewBookings
    @Modifying
    @Transactional
    @Query("DELETE FROM Booking b WHERE b.bookingId = ?1")
    void deleteBookingById(int bookingId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Flight f WHERE f.flightId = ?1 AND NOT EXISTS (SELECT b FROM Booking b WHERE b.flight.flightId = ?1)")
    void deleteFlightIfNoBookings(Long flightId);
}