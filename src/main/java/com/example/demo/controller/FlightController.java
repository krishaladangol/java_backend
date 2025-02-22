package com.example.demo.controller;

import com.example.demo.Service.FlightService;
//import com.example.demo.Service.PassengerService;
import com.example.demo.dto.FlightBookingRequest;
import com.example.demo.dto.FlightBookingResponse;
import com.example.demo.model.Flight;
//import com.example.demo.model.Passenger;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    private UserRepository userRepository; // Ensure you have this repository

    @GetMapping("/list")
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<FlightBookingResponse> addFlight(@RequestBody FlightBookingRequest request) {
        try {
            // Validate user ID
            Optional<User> userOptional = userRepository.findById(request.getUserId());
            if (userOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new FlightBookingResponse(null, null, null, null, null, null, null, "Invalid User ID"));
            }

            User user = userOptional.get();

            // Create Flight entity and associate with user
            Flight flight = new Flight();
            flight.setFlightnumber(request.getFlightNumber());
            flight.setSource(request.getSource());
            flight.setDestination(request.getDestination());
            flight.setTravelDate(request.getTravelDate());
            flight.setReturnDate(request.getReturnDate());
            flight.setPrice(request.getPrice());
            flight.setUser(user); // Associate user with flight

            // Save flight to database
            Flight savedFlight = flightService.addFlight(flight);

            // Create response
            FlightBookingResponse response = new FlightBookingResponse(
                    savedFlight.getFlightId(),
                    savedFlight.getFlightnumber(),
                    savedFlight.getSource(),
                    savedFlight.getDestination(),
                    savedFlight.getTravelDate(),
                    savedFlight.getReturnDate(),
                    savedFlight.getPrice(),
                    "Booking successful"
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new FlightBookingResponse(null, null, null, null, null, null, null, "Error: " + e.getMessage()));
        }
    }



    @PutMapping("/update/{flightId}")
    public Flight updateFlight(@RequestBody Flight flight, @PathVariable Long flightId) {
        return flightService.updateFlight(flight, flightId);
    }

    @DeleteMapping("/delete/{flightId}")
    public void deleteById(@PathVariable Long flightId) {
        flightService.deleteById(flightId);
    }


}