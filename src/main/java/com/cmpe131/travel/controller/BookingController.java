package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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