package com.cmpe131.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PetFilterService {

    private static final List<String> PET_KEYWORDS = List.of(
        "pet friendly", "pet-friendly", "pets allowed", "pets welcome",
        "dog friendly", "dog-friendly", "dogs allowed", "cats allowed",
        "animals allowed", "bring your pet"
    );

    public boolean isPetFriendly(String hotelJson) {
        if (hotelJson == null || hotelJson.isBlank()) return false;
        String lower = hotelJson.toLowerCase();
        return PET_KEYWORDS.stream().anyMatch(lower::contains);
    }
}