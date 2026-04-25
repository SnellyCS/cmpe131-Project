package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    // TODO: Create booking and save to database
    @PostMapping
    public String createBooking() {
        return "TODO: create booking endpoint";
    }

    // TODO: Get booking by ID from database
    @GetMapping("/{bookingId}")
    public String getBooking(@PathVariable int bookingId) {
        return "TODO: get booking " + bookingId;
    }
}