package com.cmpe131.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cmpe131.travel.dto.HotelDTO;

@Service
public class PetFilterService {

    private static final List<String> PET_KEYWORDS = List.of(
            "pet friendly",
            "pet-friendly",
            "pets allowed",
            "pets welcome",
            "dog friendly",
            "dog-friendly",
            "dogs allowed",
            "cats allowed",
            "animals allowed",
            "bring your pet",
            "pet allowed"
    );

    public List<HotelDTO> filterPetFriendlyHotels(List<HotelDTO> hotels) {
        if (hotels == null || hotels.isEmpty()) {
            return List.of();
        }

        return hotels.stream()
                .filter(this::isPetFriendly)
                .peek(hotel -> hotel.setIsPetFriendly(true))
                .toList();
    }

    private boolean isPetFriendly(HotelDTO hotel) {
        if (hotel == null) {
            return false;
        }

        if (hotel.isPetFriendly()) {
            return true;
        }

        String description = hotel.getDescription();

        if (description == null || description.isBlank()) {
            return false;
        }

        String lower = description.toLowerCase();

        return PET_KEYWORDS.stream().anyMatch(lower::contains);
    }

    public boolean isPetFriendly(String hotelJson) {
        if (hotelJson == null || hotelJson.isBlank()) {
            return false;
        }

        String lower = hotelJson.toLowerCase();

        return PET_KEYWORDS.stream().anyMatch(lower::contains);
    }
}