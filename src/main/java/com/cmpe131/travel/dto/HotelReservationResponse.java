package com.cmpe131.travel.dto;

import java.math.BigDecimal;

public class HotelReservationResponse {

    private Long reservationNo;
    private Long bookingId;
    private String hotelCode;
    private String hotelName;
    private String checkInDate;
    private String checkOutDate;
    private BigDecimal hotelRate;

    public HotelReservationResponse() {}

    public HotelReservationResponse(Long reservationNo, Long bookingId, String hotelCode,
                                    String hotelName, String checkInDate,
                                    String checkOutDate, BigDecimal hotelRate) {
        this.reservationNo = reservationNo;
        this.bookingId = bookingId;
        this.hotelCode = hotelCode;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotelRate = hotelRate;
    }

    // Accessors
    public Long getReservationNo() { return reservationNo; }
    public Long getBookingId() { return bookingId; }
    public String getHotelCode() { return hotelCode; }
    public String getHotelName() { return hotelName; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public BigDecimal getHotelRate() { return hotelRate; }

    // Setters
    public void setReservationNo(Long reservationNo) { this.reservationNo = reservationNo; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public void setHotelCode(String hotelCode) { this.hotelCode = hotelCode; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public void setHotelRate(BigDecimal hotelRate) { this.hotelRate = hotelRate; }
}