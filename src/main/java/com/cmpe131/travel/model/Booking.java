package com.cmpe131.travel.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Booking_Id")
    private Long bookingId;

    // User info
    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "User_Email")
    private String userEmail;

    // Flight info
    @Column(name = "Airline_Code")
    private String airlineCode;

    @Column(name = "Flight_Number")
    private String flightNumber;

    @Column(name = "Origin_Airport_Code")
    private String originAirportCode;

    @Column(name = "Destination_Airport_Code")
    private String destinationAirportCode;

    @Column(name = "Departure_Date")
    private String departureDate;

    @Column(name = "Departure_Time")
    private String departureTime;

    @Column(name = "Arrive_Date")
    private String arriveDate;

    @Column(name = "Arrive_Time")
    private String arriveTime;

    @Column(name = "Flight_Rate")
    private BigDecimal flightRate;

    // Hotel info
    @Column(name = "Hotel_Code")
    private String hotelCode;

    @Column(name = "Hotel_Name")
    private String hotelName;

    @Column(name = "Check_In_Date")
    private String checkInDate;

    @Column(name = "Check_Out_Date")
    private String checkOutDate;

    @Column(name = "Hotel_Rate")
    private BigDecimal hotelRate;

    public Booking() {}

    public Booking(Long userId, String userName, String userEmail,
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
    public Long getBookingId() {
        return bookingId;
    }
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
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
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
