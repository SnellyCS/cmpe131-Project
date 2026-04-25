package com.cmpe131.travel.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // TODO: Write SQL queries for Bookings table

    // TODO: Write SQL queries for Hotel_Reservations table

    // TODO: Write SQL queries for Flight_Reservations table
}