package com.cmpe131.travel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BookingResponse {

    @JsonProperty("Booking_Id")
    private Long bookingId;

    @JsonProperty("User_Id")
    private Long userId;

    @JsonProperty("Agent_Id")
    private Long agentId;

    @JsonProperty("Start_Date")
    private String startDate;

    @JsonProperty("End_Date")
    private String endDate;

    @JsonProperty("hotel_reservations")
    private List<HotelReservationResponse> hotelReservations;

    @JsonProperty("flight_reservations")
    private List<FlightReservationResponse> flightReservations;

    public BookingResponse() {}

    public BookingResponse(
            Long bookingId,
            Long userId,
            Long agentId,
            String startDate,
            String endDate,
            List<HotelReservationResponse> hotelReservations,
            List<FlightReservationResponse> flightReservations
    ) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.agentId = agentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotelReservations = hotelReservations;
        this.flightReservations = flightReservations;
    }

    public Long getBookingId() { return bookingId; }
    public Long getUserId() { return userId; }
    public Long getAgentId() { return agentId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public List<HotelReservationResponse> getHotelReservations() { return hotelReservations; }
    public List<FlightReservationResponse> getFlightReservations() { return flightReservations; }

    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public void setHotelReservations(List<HotelReservationResponse> hotelReservations) {
        this.hotelReservations = hotelReservations;
    }
    public void setFlightReservations(List<FlightReservationResponse> flightReservations) {
        this.flightReservations = flightReservations;
    }
}