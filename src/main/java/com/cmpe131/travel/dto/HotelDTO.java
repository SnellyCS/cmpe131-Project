package com.cmpe131.travel.dto;

public class HotelDTO {

    private String hotelName;
    private String description;
    private String address;
    private double price;
    private boolean isPetFriendly;

    public HotelDTO() {}

    public HotelDTO(String hotelName, String description, String address, double price, boolean isPetFriendly) {
        this.hotelName = hotelName;
        this.description = description;
        this.address = address;
        this.price = price;
        this.isPetFriendly = isPetFriendly;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    public void setIsPetFriendly(boolean isPetFriendly) {
        this.isPetFriendly = isPetFriendly;
    }
}