package com.example.demo.controller;

import com.example.demo.Service.BookingService;
import com.example.demo.Service.FlightService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.BookingRequest;
import com.example.demo.model.Booking;
import com.example.demo.model.Flight;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private FlightRepository flightRepository; // To fetch flight details
    @Autowired
    private FlightService flightService;
    /*
    @GetMapping("/list")
    public List<Booking> getAllUser() {
        return bookingService.getAll();
    }




    @PutMapping("/update/{bookingId}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable int bookingId) {
        return bookingService.updateBooking(booking, bookingId);
    }
    @DeleteMapping("/delete/{bookingId}")
    public void deleteById(@PathVariable int bookingId){
        bookingService.deleteByBookingId(bookingId);
    }
*/
    @PostMapping("/add")
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest request) {
        try {
            // Fetch flight by ID
            Optional<Flight> flightOptional = flightRepository.findById(request.getFlightId());
            if (!flightOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Flight not found with ID: " + request.getFlightId());
            }

            Flight flight = flightOptional.get();

            // Create booking object
            Booking booking = new Booking(
                    flight,
                    request.getFirstName(),
                    request.getMiddleName(),
                    request.getLastName(),
                    request.getGender(),
                    request.getAge(),
                    request.getDob(),
                    request.getPassportNumber(),
                    request.getCitizenshipNumber(),
                    request.getPhoneNumber()
            );

            // Save booking using the service layer
            Booking savedBooking = bookingService.addBooking(booking);
            return ResponseEntity.ok(savedBooking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating booking: " + e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }


   /* @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody Booking updatedBooking) {
        Booking updated = bookingService.updateBooking(bookingId, updatedBooking);
        return ResponseEntity.ok(updated);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setFirstName(updatedBooking.getFirstName());
            booking.setLastName(updatedBooking.getLastName());
            booking.setPhoneNumber(updatedBooking.getPhoneNumber());
            bookingRepository.save(booking);
            return ResponseEntity.ok(booking);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking deleted successfully.");
    }



}