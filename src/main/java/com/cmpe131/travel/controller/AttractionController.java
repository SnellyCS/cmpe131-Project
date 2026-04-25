package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attractions")
public class AttractionController {

    // TODO: Search attractions/activities near destination
    @GetMapping("/search")
    public String searchAttractions() {
        return "TODO: attraction search endpoint";
    }
}