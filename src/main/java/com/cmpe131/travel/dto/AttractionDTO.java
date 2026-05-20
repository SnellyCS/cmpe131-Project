package com.cmpe131.travel.dto;
public class AttractionDTO {

    private String id;
    private String name;
    private String category;
    private String icon;
    private String location;
    private String duration;
    private double pricePerPerson;
    private double totalPrice;
    private int maxGroupSize;
    private String rating;
    private int reviews;
    private String description;

    public AttractionDTO() {}

    public AttractionDTO(String id, String name, String category, String icon,
                         String location, String duration, double pricePerPerson,
                         double totalPrice, int maxGroupSize, String rating,
                         int reviews, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.icon = icon;
        this.location = location;
        this.duration = duration;
        this.pricePerPerson = pricePerPerson;
        this.totalPrice = totalPrice;
        this.maxGroupSize = maxGroupSize;
        this.rating = rating;
        this.reviews = reviews;
        this.description = description;
    }

    // Getters and setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getPricePerPerson() { return pricePerPerson; }
    public void setPricePerPerson(double pricePerPerson) { this.pricePerPerson = pricePerPerson; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public int getMaxGroupSize() { return maxGroupSize; }
    public void setMaxGroupSize(int maxGroupSize) { this.maxGroupSize = maxGroupSize; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public int getReviews() { return reviews; }
    public void setReviews(int reviews) { this.reviews = reviews; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}