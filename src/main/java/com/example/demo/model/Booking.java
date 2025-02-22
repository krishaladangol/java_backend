package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private String gender;

    @Column(name = "passenger_age", nullable = false)
    private Integer age;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(nullable = false)
    private String passportNumber;

    private String phoneNumber;
    private String citizenshipNumber;
    /*@Column(nullable = false)
    private String paymentStatus = "Not Paid"; // Default status
    */
    //@ManyToOne
   /* @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // This will properly handle the other side of the relationship
    private List<Payment> payments; // One booking can have many payments
*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id", nullable = false)  // Foreign key to the flight
    // @JsonBackReference // Add this annotation to prevent circular references
    @JsonIgnoreProperties("bookings") // Prevents recursion issues
    private Flight flight;

    // Default constructor
    public Booking() {}

    // Constructor with parameters
    public Booking(Flight flight, String firstName, String middleName, String lastName, String gender, Integer age, String dob, String passportNumber, String citizenshipNumber, String phoneNumber) {
        this.flight = flight;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = (age != null) ? age : 0;  // Set a default value if null
        this.dob = dob;
        this.passportNumber = passportNumber;
        this.citizenshipNumber = citizenshipNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   /* public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }*/

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}