package com.example.demo.controller;


//package com.example.demo.controller;

import com.example.demo.Service.FlightInfoService;
import com.example.demo.Service.FlightInfoService;
import com.example.demo.model.FlightInfo;
import com.example.demo.repository.FlightInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flightinfo")
public class FlightInfoController {
    @Autowired
    private FlightInfoService flightinfoService;
    @Autowired
    private FlightInfoRepository flightinfoRepository;

    @PostMapping("/add")
/*
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> addFlight(@RequestBody FlightInfo flightinfo) {
    FlightInfo savedFlight = flightinfoRepository.save(flightinfo);
    return ResponseEntity.ok(savedFlight);
}*/

    public void addFlight(@RequestBody FlightInfo flightinfo){
        flightinfoService.add(flightinfo);
    }
   /*@GetMapping
    public List<FlightInfo> getAllFlights() {
        return flightinfoService.getAllFlights();
    }*/
    /*@DeleteMapping("/{flightIdinfo}")
    public void deleteFlight(@PathVariable Long flightIdinfo) {
        flightinfoService.deleteFlight(flightIdinfo);
    }*/


    // Endpoint to fetch all flights
    @GetMapping("/all")
    public List<FlightInfo> getAllFlights() {
        return flightinfoService.getAllFlights();
    }

    @GetMapping("/search")
    public List<FlightInfo> searchFlights(

            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return flightinfoService.searchFlights(source, destination, travelDate, returnDate);
    }

    // Update flight details
    @PutMapping("/update/{flightIdinfo}")
    public FlightInfo updateFlight(@PathVariable Long flightIdinfo, @RequestBody FlightInfo flight) {
        return flightinfoService.updateFlight(flightIdinfo, flight);
    }
    @DeleteMapping("/delete/{flightIdinfo}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightIdinfo) {
        flightinfoService.deleteFlight(flightIdinfo);
        return ResponseEntity.ok("Flight deleted successfully");
    }

}