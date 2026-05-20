package com.cmpe131.travel.controller;

import org.springframework.web.bind.annotation.*;

import com.cmpe131.travel.dto.LoginRequest;
import com.cmpe131.travel.dto.LoginResponse;
import com.cmpe131.travel.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://agenta.local:5173",
        "http://agentb.local:5173"
})
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}