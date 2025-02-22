package com.example.demo.Service.impl;

import com.example.demo.Service.BookingService;
import com.example.demo.model.Booking;
//import com.example.demo.model.FlightInfo;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
//import com.example.demo.repository.FlightInfoRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private FlightRepository flightRepository;


    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking addBooking(Booking booking) {

        //booking.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking, int bookingId) {
        getByBookingId(bookingId);
        booking.setBookingId(bookingId);
        //booking.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    // @Transactional
    public void deleteByBookingId(int bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));



        bookingRepository.deleteById(bookingId);

    }


    @Override
    public Booking getByBookingId(int bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        Booking booking= optionalBooking.orElseThrow((() -> new RuntimeException("User not found")));

        return booking;
    }
    //Change code
    public List<Booking> getAllBookings() {
        //return bookingRepository.findAll();
        return bookingRepository.findAllWithFlights(); // Fetch all bookings with flight details

    }

    public Booking getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBooking(int bookingId, Booking updatedBooking) {
        Booking existingBooking = getBookingById(bookingId);
        existingBooking.setFirstName(updatedBooking.getFirstName());
        existingBooking.setLastName(updatedBooking.getLastName());
        existingBooking.setGender(updatedBooking.getGender());
        existingBooking.setPassportNumber(updatedBooking.getPassportNumber());
        existingBooking.setCitizenshipNumber(updatedBooking.getCitizenshipNumber());
        existingBooking.setPhoneNumber(updatedBooking.getPhoneNumber());
        return bookingRepository.save(existingBooking);
    }

    /* public void deleteBooking(int bookingId) {
        // bookingRepository.deleteById(bookingId);
         bookingRepository.findById(bookingId).ifPresent(booking -> {
             bookingRepository.delete(booking); // Deletes both booking and related flight
         });
     }*/
   /* @Transactional
    @Override
    public void deleteBooking(int bookingId) {
        Booking booking = getBookingById(bookingId);
        Long flightId = booking.getFlight().getFlightId();

        bookingRepository.deleteBookingById(bookingId);
        bookingRepository.deleteFlightIfNoBookings(flightId);
    }*/
    @Transactional
    @Override
    public void deleteBooking(int bookingId) {
        Booking booking = getByBookingId(bookingId);
        Long flightId = booking.getFlight().getFlightId();

        // Delete payments related to this flight
        paymentRepository.deleteByFlightId(flightId);

        // Delete the booking
        bookingRepository.deleteById(bookingId);

        // Only delete flight if no more bookings exist for it
        if (!bookingRepository.existsByFlightId(flightId)) {
            flightRepository.deleteById(flightId);
        }
    }
}