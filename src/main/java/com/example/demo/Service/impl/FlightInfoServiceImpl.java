package com.example.demo.Service.impl;

import com.example.demo.Service.FlightInfoService;
import com.example.demo.model.FlightInfo;
import com.example.demo.model.FlightInfo;
import com.example.demo.repository.FlightInfoRepository;
import com.example.demo.repository.FlightInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {

    @Autowired
    private FlightInfoRepository flightinfoRepository;

    @Override
    public FlightInfo add(FlightInfo flightinfo) {
        return flightinfoRepository.save(flightinfo);  // Save the flight in the database
    }
    @Override
    public List<FlightInfo> getAllFlights() {
        return flightinfoRepository.findAll();
    }
    @Override
    public void deleteFlight(Long flightIdinfo) {
        flightinfoRepository.deleteById(flightIdinfo);
    }
    @Override
    public boolean isFlightAvailable(String source, String destination, LocalDate travelDate, LocalDate returnDate) {
        List<FlightInfo> flights = flightinfoRepository.findBySourceAndDestinationAndTravelDateAndReturnDate(source, destination, travelDate, returnDate);
        return !flights.isEmpty(); // Return true if there are available flights
    }
    @Override
    public List<FlightInfo> searchFlights(String source, String destination, LocalDate travelDate, LocalDate returnDate) {
        /*if (returnDate == null) { // One-Way
            return flightinfoRepository.findBySourceAndDestinationAndTravelDate(source, destination, travelDate);

        }
       else { // Two-Way

            return flightinfoRepository.findBySourceAndDestinationAndTravelDateAndReturnDate(source, destination, travelDate, returnDate);
        }*/
        if (returnDate == null) { // One-way flight search
            return flightinfoRepository.findOneWayFlights(source, destination, travelDate);
        } else { // Round-trip search
            return flightinfoRepository.findBySourceAndDestinationAndTravelDateAndReturnDate(source, destination, travelDate, returnDate);
        }
    }
    public FlightInfo updateFlight(Long flightIdinfo, FlightInfo updatedFlight) {
        Optional<FlightInfo> existingFlight = flightinfoRepository.findById(flightIdinfo);
        if (existingFlight.isPresent()) {
            FlightInfo flight = existingFlight.get();
            flight.setFlightnumber(updatedFlight.getFlightnumber());
            flight.setSource(updatedFlight.getSource());
            flight.setDestination(updatedFlight.getDestination());
            flight.setTravelDate(updatedFlight.getTravelDate());
            flight.setReturnDate(updatedFlight.getReturnDate());
            flight.setPrice(updatedFlight.getPrice());
            return flightinfoRepository.save(flight);
        }
        return null;
    }


}