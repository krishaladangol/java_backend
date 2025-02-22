package com.example.demo.dto;




import java.time.LocalDate;

public class FlightBookingRequest {
    private int userId;
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private LocalDate returnDate;
    private Double price;

    // Constructors
    public FlightBookingRequest() {}

    public FlightBookingRequest(int userId, String flightNumber, String source, String destination,
                                LocalDate travelDate, LocalDate returnDate, Double price) {
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}