package com.cmpe131.travel.dto;
import java.util.List;

public class HotelDTO {

    private String hotelName;
    private String description;
    private String address;
    private double price;
    private boolean isPetFriendly;
    private String id;
    private String name;
    private String location;
    private int stars;
    private double pricePerNight;
    private double totalPrice;
    private int nights;
    private String checkIn;
    private String checkOut;
    private List<String> amenities;
    private double rating;
    private int reviews;
    private String roomType;
    private int imageIndex;
    private String imageUrl;

    public HotelDTO() {}
    public HotelDTO(String hotelName, String description, String address,
                    double price, boolean isPetFriendly) {

        this.hotelName = hotelName;
        this.description = description;
        this.address = address;
        this.price = price;
        this.isPetFriendly = isPetFriendly;

        this.id = hotelName;
        this.name = hotelName;
        this.location = address;
        this.stars = 3;
        this.pricePerNight = price;
        this.totalPrice = price;
        this.nights = 1;
        this.checkIn = "";
        this.checkOut = "";
        this.amenities = List.of();
        this.rating = 4.0;
        this.reviews = 100;
        this.roomType = "Standard Room";
        this.imageIndex = 0;
        this.imageUrl = null;
    }

    public HotelDTO(String hotelName, String description, String address, double price,
                    boolean isPetFriendly, String id, String name, String location,
                    int stars, double pricePerNight, double totalPrice, int nights,
                    String checkIn, String checkOut, List<String> amenities,
                    double rating, int reviews, String roomType,
                    int imageIndex, String imageUrl) {

        this.hotelName = hotelName;
        this.description = description;
        this.address = address;
        this.price = price;
        this.isPetFriendly = isPetFriendly;
        this.id = id;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
        this.totalPrice = totalPrice;
        this.nights = nights;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.amenities = amenities;
        this.rating = rating;
        this.reviews = reviews;
        this.roomType = roomType;
        this.imageIndex = imageIndex;
        this.imageUrl = imageUrl;
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

    public void setPetFriendly(boolean petFriendly) {
        isPetFriendly = petFriendly;
    }

    public void setIsPetFriendly(boolean isPetFriendly) {
        this.isPetFriendly = isPetFriendly;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}