package com.cmpe131.travel.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int testConnection() {
        return jdbcTemplate.queryForObject("SELECT 1", Integer.class);
    }

    public String getAllUsers() {
    return jdbcTemplate.query(
        "SELECT First_Name, Last_Name FROM Users",
        (rs, rowNum) -> rs.getString("First_Name") + " " + rs.getString("Last_Name")
    ).toString();
    }

    // TODO: Write SQL queries for Bookings table

    // TODO: Write SQL queries for Hotel_Reservations table

    // TODO: Write SQL queries for Flight_Reservations table
}