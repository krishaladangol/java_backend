package com.example.demo.Service;


import com.example.demo.model.FlightInfo;

import java.time.LocalDate;
import java.util.List;


public interface FlightInfoService {
    FlightInfo add(FlightInfo flightinfo);
    List<FlightInfo> getAllFlights();
    void deleteFlight(Long flightIdinfo);
    boolean isFlightAvailable(String source, String destination, LocalDate travelDateinfo,LocalDate returnDateinfo);
    // List<FlightInfo> searchFlights(String source, String destination, LocalDate travelDate, LocalDate returnDate,int numTravellers, String flightType);
    List<FlightInfo> searchFlights(String source, String destination, LocalDate travelDate, LocalDate returnDate);
    // List<FlightInfo> getAvailableFlights();
    // List<FlightInfo> searchFlights(String source, String destination, LocalDate travelDate, LocalDate returnDate);
    FlightInfo updateFlight(Long flightIdinfo, FlightInfo updatedFlight);
}