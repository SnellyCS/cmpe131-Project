package com.cmpe131.travel.controller;

import com.cmpe131.travel.dto.AttractionDTO;
import com.cmpe131.travel.service.AttractionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    /**
     * Search activities/attractions for a destination.
     *
     * Query params (mirrors what activityService.js sends):
     *   dest_name     – city name or airport code, e.g. "Paris" or "CDG"   (required)
     *   country_name  – optional country hint, e.g. "France"
     *   start_date    – ISO date string (YYYY-MM-DD), used for future date logic
     *   end_date      – ISO date string (YYYY-MM-DD)
     *   adults        – number of adults  (default 1)
     *   children      – number of children (default 0)
     *
     * Returns a JSON array of AttractionDTO objects ready for ActivityList.vue.
     */
    @GetMapping("/search")
    public List<AttractionDTO> searchAttractions(
            @RequestParam("dest_name") String destName,
            @RequestParam(value = "country_name", required = false) String countryName,
            @RequestParam(value = "start_date", required = false) String startDate,
            @RequestParam(value = "end_date", required = false) String endDate,
            @RequestParam(value = "adults", defaultValue = "1") int adults,
            @RequestParam(value = "children", defaultValue = "0") int children
    ) {
        return attractionService.searchAttractions(destName, countryName, adults, children);
    }
}