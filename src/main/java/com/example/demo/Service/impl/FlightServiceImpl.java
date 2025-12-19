package com.example.demo.Service.impl;
import com.example.demo.Service.FlightService;
import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//}
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    /* @Override
     public Flight add(Flight flight) {
         return flightRepository.save(flight);  // Save the flight in the database
     }*/
    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    @Override
    public Flight updateFlight(Flight flight, Long flightId){
        //flight.getById(flightId);
        flight.setFlightId(flightId);
        return flightRepository.save(flight);

    }
    @Override
    public void deleteById(Long flightId){
        flightRepository.deleteById(flightId);
    }
    @Override
    public Flight getById(Long flightId) {
        Optional<Flight> optionalFlightinfo = flightRepository.findById(flightId);
        Flight flightinfo = optionalFlightinfo.orElseThrow((() -> new RuntimeException("User not found")));

        return flightinfo;
    }
    @Override
    public Flight findById(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }
}