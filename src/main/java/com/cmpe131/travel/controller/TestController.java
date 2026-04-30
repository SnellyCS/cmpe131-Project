package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe131.travel.repository.BookingRepository;

@RestController
public class TestController {

    private final BookingRepository bookingRepository;

    public TestController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/db-test")
    public String testDB() {
        return "DB result: " + bookingRepository.testConnection();
    }

    @GetMapping("/users")
    public String getUsers() {
        return bookingRepository.getAllUsers();
    }
}