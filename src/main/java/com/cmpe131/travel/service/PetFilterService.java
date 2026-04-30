package com.cmpe131.travel.service;

import com.cmpe131.travel.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetFilterService {

    // Filters hotel data from HotelService
    public List<HotelDTO> filterPetFriendlyHotels(List<HotelDTO> hotels) {

        // If HotelService gives no hotels, return empty list
        if (hotels == null || hotels.isEmpty()) {
            return List.of();
        }

        // Keep only pet-friendly hotels
        return hotels.stream()
                .filter(this::isPetFriendly)
                .toList();
    }

    // Checks one hotel for pet-friendly info
    private boolean isPetFriendly(HotelDTO hotel) {

        if (hotel == null) {
            return false;
        }

        // If already marked pet-friendly
        if (hotel.isPetFriendly()) {
            return true;
        }

        // Check description text
        String description = hotel.getDescription();

        if (description == null) {
            return false;
        }

        String data = description.toLowerCase();

        return data.contains("pet friendly") ||
               data.contains("pets allowed") ||
               data.contains("dog friendly") ||
               data.contains("pets") ||
               data.contains("pet");
    }
}