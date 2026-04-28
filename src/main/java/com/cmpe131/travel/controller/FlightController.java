package com.cmpe131.travel.controller;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/reservations")
    public FlightReservationResponse createFlightReservation(@RequestBody FlightReservationRequest request) {
        return service.createFlightReservation(request);
    }


    @GetMapping("/test")
    public String getAllFlights() {
        return "flgiht from SFO to JFK";
    }
}