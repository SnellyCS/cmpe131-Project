package com.cmpe131.travel.dto;

// DTO = used to pass hotel data between layers (not stored in database)
public class HotelDTO {
    
    // Name of hotel
    private String hotelName;

    // Description from API (used for pet filtering)
    private String description;

    // Hotel address/location
    private String address;

    // Price per night (or from API)
    private double price;

    // Optional flag if API already marks hotel as pet-friendly
    private boolean isPetFriendly;

    // Empty constructor (needed for SpringBoot/JSON)
    public HotelDTO() {}

    // Constructor to create hotel objects
    public HotelDTO(String hotelName, String description, String address, double price, boolean isPetFriendly) {
        this.hotelName = hotelName;
        this.description = description;
        this.address = address;
        this.price = price;
        this.isPetFriendly = isPetFriendly;
    }

    // Get hotel name
    public String getHotelName() {
        return hotelName;
    }

    // Set hotel name
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    // Get description
    public String getDescription() {
        return description;
    }

    // Set description
    public void setDescription(String description) {
        this.description = description;
    }

    // Get address
    public String getAddress() {
        return address;
    }

    // Set hotel name
    public void setAddress(String address) {
        this.address = address;
    }

    // Get price
    public double getPrice() {
        return price;
    }

    // Set price 
    public void setPrice(double price) {
        this.price = price;
    }

    // Checks if marked pet-friendly
    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    // Set pet-friendly flag
    public void setIsPetFriendly(boolean isPetFriendly) {
        this.isPetFriendly = isPetFriendly;
    }
}