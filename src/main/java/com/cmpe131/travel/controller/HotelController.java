package com.cmpe131.travel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cmpe131.travel.dto.HotelDTO;
import com.cmpe131.travel.dto.HotelReservationResponse;
import com.cmpe131.travel.service.HotelService;
import com.cmpe131.travel.service.PetFilterService;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;
    private final PetFilterService petFilterService;

    public HotelController(HotelService hotelService, PetFilterService petFilterService) {
        this.hotelService = hotelService;
        this.petFilterService = petFilterService;
    }

    @GetMapping("/raw")
    public String rawSearch(
            @RequestParam String destId,
            @RequestParam String checkin,
            @RequestParam String checkout
    ) {
        return hotelService.getRawResponse(destId, checkin, checkout);
    }

    @GetMapping(value = "/search", produces = "application/json")
    public String searchHotels(
            @RequestParam("dest_name") String destName,
            @RequestParam(value = "country_name", required = false) String countryName,
            @RequestParam("checkin_date") String checkin,
            @RequestParam("checkout_date") String checkout,
            @RequestParam(value = "adults_number", defaultValue = "2") int adults,
            @RequestParam(value = "room_number", defaultValue = "1") int roomNumber
    ) {
        return hotelService.searchHotelsRaw(destName, checkin, checkout, adults, roomNumber);
    }

    @GetMapping("/pet-friendly")
    public List<HotelDTO> searchPetFriendlyHotels(
            @RequestParam String destId,
            @RequestParam String checkin,
            @RequestParam String checkout,
            @RequestParam(defaultValue = "2") int adults,
            @RequestParam(defaultValue = "1") int roomNumber
    ) {
        List<HotelDTO> hotels = hotelService.searchHotels(destId, checkin, checkout, adults, roomNumber);
        return petFilterService.filterPetFriendlyHotels(hotels);
    }

    @GetMapping("/reservations/{bookingId}")
    public HotelReservationResponse getHotelReservationByBookingId(@PathVariable Long bookingId) {
        return hotelService.getHotelReservationByBookingId(bookingId);
    }
}