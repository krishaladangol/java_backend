package com.example.demo.model;
//admin le chalaune means add garbne wala
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;


import java.time.LocalDate;
@Entity
@Table(name = "flightinfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long flightIdinfo;
    private String destination;
    private String source;
    private LocalDate travelDate;
    @Column(nullable = true)
    private LocalDate returnDate;
    private double price;
    private int availableSeats;
    private String flightnumber;

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }



    public Long getFlightIdinfo() {
        return flightIdinfo;
    }

    public void setFlightIdinfo(Long flightIdinfo) {
        this.flightIdinfo = flightIdinfo;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}