package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @GetMapping("/search")
    public List<Map<String, Object>> searchFlights(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String departDate
    ) {
        List<Map<String, Object>> flights = new ArrayList<>();

        Map<String, Object> flight1 = new HashMap<>();
        flight1.put("airline", "United");
        flight1.put("flightNumber", "UA123");
        flight1.put("origin", origin);
        flight1.put("destination", destination);
        flight1.put("departDate", departDate);
        flight1.put("price", 250);

        flights.add(flight1);

        return flights;
    }
}
