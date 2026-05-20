package com.cmpe131.travel.service;

import org.springframework.stereotype.Service;

import com.cmpe131.travel.dto.LoginRequest;
import com.cmpe131.travel.dto.LoginResponse;
import com.cmpe131.travel.dto.UserDTO;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {
        String loginValue = request.getEmail();

        if (loginValue == null || loginValue.isBlank()) {
            loginValue = request.getUsername();
        }

        String password = request.getPassword();

        if (loginValue == null || password == null) {
            return failedLogin();
        }

        boolean validLogin =
                (loginValue.equalsIgnoreCase("demo@test.com")
                || loginValue.equalsIgnoreCase("demo")
                || loginValue.equalsIgnoreCase("agent1"))
                && password.equals("password123");

        if (validLogin) {
            UserDTO user = new UserDTO(
                    1L,
                    "Demo User",
                    "demo@test.com",
                    "USER"
            );

            return new LoginResponse(
                    true,
                    "Login successful",
                    "demo-token-123",
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getRole(),
                    user
            );
        }

        return failedLogin();
    }

    private LoginResponse failedLogin() {
        return new LoginResponse(
                false,
                "Invalid email or password",
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}