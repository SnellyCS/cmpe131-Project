package com.cmpe131.travel.dto;
import java.math.BigDecimal;

public class BookingRequest {

    // User info
    private Long userId;
    private String userName;
    private String userEmail;

    // Flight info
    private String airlineCode;
    private String flightNumber;
    private String originAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String departureTime;
    private String arriveDate;
    private String arriveTime;
    private BigDecimal flightRate;

    // Hotel info
    private String hotelCode;
    private String hotelName;
    private String checkInDate;
    private String checkOutDate;
    private BigDecimal hotelRate;

    public BookingRequest() {}

    public BookingRequest(Long userId, String userName, String userEmail,
                          String airlineCode, String flightNumber, String originAirportCode,
                          String destinationAirportCode, String departureDate, String departureTime,
                          String arriveDate, String arriveTime, BigDecimal flightRate,
                          String hotelCode, String hotelName, String checkInDate,
                          String checkOutDate, BigDecimal hotelRate) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.flightRate = flightRate;
        this.hotelCode = hotelCode;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotelRate = hotelRate;
    }

    // Accessors
    public Long getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getAirlineCode() {
        return airlineCode;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public String getOriginAirportCode() {
        return originAirportCode;
    }
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public String getArriveDate() {
        return arriveDate;
    }
    public String getArriveTime() {
        return arriveTime;
    }
    public BigDecimal getFlightRate() {
        return flightRate;
    }
    public String getHotelCode() {
        return hotelCode;
    }
    public String getHotelName() {
        return hotelName;
    }
    public String getCheckInDate() {
        return checkInDate;
    }
    public String getCheckOutDate() {
        return checkOutDate;
    }
    public BigDecimal getHotelRate() {
        return hotelRate;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
    }
    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
    public void setFlightRate(BigDecimal flightRate) {
        this.flightRate = flightRate;
    }
    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public void setHotelRate(BigDecimal hotelRate) {
        this.hotelRate = hotelRate;
    }
}