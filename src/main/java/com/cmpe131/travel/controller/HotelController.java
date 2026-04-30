package com.cmpe131.travel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe131.travel.dto.HotelDTO;
import com.cmpe131.travel.service.HotelService;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // DEBUG: see raw API response to check JSON structure
    @GetMapping("/raw")
    public String rawSearch(
        @RequestParam String destId,
        @RequestParam String checkin,
        @RequestParam String checkout
    ) {
        return hotelService.getRawResponse(destId, checkin, checkout);
    }

    @GetMapping("/search")
    public List<HotelDTO> searchHotels(
        @RequestParam String destId,
        @RequestParam String checkin,
        @RequestParam String checkout,
        @RequestParam(defaultValue = "2") int adults,
        @RequestParam(defaultValue = "1") int roomNumber
    ) {
        return hotelService.searchHotels(destId, checkin, checkout, adults, roomNumber);
    }

    @GetMapping("/pet-friendly")
    public List<HotelDTO> searchPetFriendlyHotels(
        @RequestParam String destId,
        @RequestParam String checkin,
        @RequestParam String checkout,
        @RequestParam(defaultValue = "2") int adults,
        @RequestParam(defaultValue = "1") int roomNumber
    ) {
        return hotelService.searchPetFriendlyHotels(destId, checkin, checkout, adults, roomNumber);
    }
}