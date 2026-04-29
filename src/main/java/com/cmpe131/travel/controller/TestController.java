package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/db-test")
    public String testDB() {
        return "DB connection OK";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "TODO: users endpoint";
    }
}