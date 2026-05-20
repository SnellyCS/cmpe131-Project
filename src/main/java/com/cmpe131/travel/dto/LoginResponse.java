package com.cmpe131.travel.dto;

public class LoginResponse {
    private boolean success;
    private String message;
    private String token;

    private Long userId;
    private String userName;
    private String userEmail;
    private String role;

    private UserDTO user;

    public LoginResponse() {}

    public LoginResponse(boolean success, String message, String token,
                         Long userId, String userName, String userEmail,
                         String role, UserDTO user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.role = role;
        this.user = user;
    }

    public boolean getSuccess() { return success; }
    public String getMessage() { return message; }
    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getRole() { return role; }
    public UserDTO getUser() { return user; }

    public void setSuccess(boolean success) { this.success = success; }
    public void setMessage(String message) { this.message = message; }
    public void setToken(String token) { this.token = token; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setRole(String role) { this.role = role; }
    public void setUser(UserDTO user) { this.user = user; }
}