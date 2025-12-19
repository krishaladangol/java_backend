package com.example.demo.dto;



//package com.yourpackage.dto;

import java.time.LocalDate;

public class FlightBookingResponse {
    private Long bookingId;
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private LocalDate returnDate;
    private Double price;
    private String message;

    // Constructors
    public FlightBookingResponse() {}

    public FlightBookingResponse(Long bookingId, String flightNumber, String source, String destination,
                                 LocalDate travelDate, LocalDate returnDate, Double price, String message) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.returnDate = returnDate;
        this.price = price;
        this.message = message;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}