package com.cmpe131.travel.controller;

import com.cmpe131.travel.service.HotelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // TODO: Search hotels from external Booking/RapidAPI API
    // Example: /api/v1/hotels/search?destId=-553173&checkin=2026-06-01
    @GetMapping("/search")
    public String searchHotels() {
        return "TODO: hotel search endpoint";
    }

    // TODO: Search hotels, then filter to only pet-friendly options
    @GetMapping("/pet-friendly")
    public String searchPetFriendlyHotels() {
        return "TODO: pet-friendly hotel search endpoint";
    }
}