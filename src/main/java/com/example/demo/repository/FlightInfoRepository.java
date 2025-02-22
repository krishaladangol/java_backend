package com.example.demo.repository;

import com.example.demo.model.FlightInfo;
import com.example.demo.model.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {

    /*List<FlightInfo> findBySourceAndDestinationAndTravelDate(String source, String destination, LocalDate travelDate);
     // For Two-Way flights
      List<FlightInfo> findBySourceAndDestinationAndTravelDateAndReturnDate(String source, String destination, LocalDate travelDate, LocalDate returnDate);
  */
    // Find flights for one-way trips (ignore returnDate)
    @Query("SELECT f FROM FlightInfo f WHERE f.source = :source AND f.destination = :destination AND f.travelDate = :travelDate")
    List<FlightInfo> findOneWayFlights(
            @Param("source") String source,
            @Param("destination") String destination,
            @Param("travelDate") LocalDate travelDate
    );

    // Find flights for round-trip bookings
    List<FlightInfo> findBySourceAndDestinationAndTravelDateAndReturnDate(
            String source, String destination, LocalDate travelDate, LocalDate returnDate
    );
}