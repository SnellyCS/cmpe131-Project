package com.cmpe131.travel.controller;

import com.cmpe131.travel.dto.HotelDTO;
import com.cmpe131.travel.service.HotelService;
import com.cmpe131.travel.service.PetFilterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;
    private final PetFilterService petFilterService;

    public HotelController(HotelService hotelService, PetFilterService petFilterService) {
        this.hotelService = hotelService;
        this.petFilterService = petFilterService;
    }

    @GetMapping("/search")
    public String searchHotels() {
        return "TODO: hotel search endpoint";
    }

    @GetMapping("/pet-friendly")
    public List<HotelDTO> searchPetFriendlyHotels(
            @RequestParam(required = false) String destId,
            @RequestParam(required = false) String checkin,
            @RequestParam(required = false) String checkout
    ) {

        // TEMP MOCK DATA TO TEST
        // Later, replace this with Kai's HotelService data
        List<HotelDTO> hotels = List.of(
                new HotelDTO(
                        "The Plaza",
                        "Luxury hotel. Pet friendly rooms available.",
                        "768 5th Ave, New York",
                        450.00,
                        true
                ),
                new HotelDTO(
                        "The Savoy",
                        "Historic luxury hotel near the river.",
                        "Strand, London",
                        500.00,
                        false
                ),
                new HotelDTO(
                        "Dog Friendly Inn",
                        "Pets allowed and dog friendly stay.",
                        "123 Pet Street",
                        199.99,
                        false
                )
        );

        return petFilterService.filterPetFriendlyHotels(hotels);
    }

    /*
     * Note for when Kai is done:
     *
     * Replace the mock hotel list with:
     *
     * List<HotelDTO> hotels = hotelService.searchHotels(destId, checkin, checkout);
     * return petFilterService.filterPetFriendlyHotels(hotels);
     */
}