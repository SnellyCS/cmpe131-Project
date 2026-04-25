package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    // TODO: Search flights using external API
    // Example: SFO -> JFK, depart date, return date
    @GetMapping("/search")
    public String searchFlights() {
        return "TODO: flight search endpoint";
    }
}