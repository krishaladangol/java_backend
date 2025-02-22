/*package com.example.demo.Service;

import com.example.demo.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    //List<Booking> findALlId(String bookingId);
    Booking addBooking(Booking booking);
    Booking updateBooking(Booking booking,int bookingId);
    void deleteByBookingId(int bookingId);

    Booking getByBookingId(int bookingId);
}*/
package com.example.demo.Service;

import com.example.demo.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    //List<Booking> findALlId(String bookingId);
    Booking addBooking(Booking booking);
    Booking updateBooking(Booking booking,int bookingId);
    void deleteByBookingId(int bookingId);

    Booking getByBookingId(int bookingId);
    public List<Booking> getAllBookings();
    public Booking getBookingById(int bookingId);
    public Booking updateBooking(int bookingId, Booking updatedBooking);
    public void deleteBooking(int bookingId);
}