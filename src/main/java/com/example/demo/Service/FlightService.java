/*package com.example.demo.Service;

import com.example.demo.model.Flightinfo;
//import com.example.demo.model.Passenger;

import java.util.List;

public interface FlightService {
    List<Flightinfo> getAll();

    Flightinfo addFlight(Flightinfo flightinfo);
    Flightinfo updateFlight(Flightinfo flightinfo,int flightId);
    void deleteById(int flightId);

    Flightinfo getById(int flightId);
}*/
package com.example.demo.Service;

import com.example.demo.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<Flight> getAll();

    Flight addFlight(Flight flight);
    Flight updateFlight(Flight flight, Long flightId);
    void deleteById(Long flightId);
    public Flight findById(Long flightId);
    Flight getById(Long flightId);
}