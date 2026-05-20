package com.cmpe131.travel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public class BookingRequest {

    @JsonProperty("User_Id")
    private Long userId;

    @JsonProperty("Agent_Id")
    private Long agentId;

    @JsonProperty("Start_Date")
    private String startDate;

    @JsonProperty("End_Date")
    private String endDate;

    @JsonProperty("hotel_reservations")
    private List<HotelReservationItem> hotelReservations;

    @JsonProperty("flight_reservations")
    private List<FlightReservationItem> flightReservations;

    public Long getUserId() { return userId; }
    public Long getAgentId() { return agentId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public List<HotelReservationItem> getHotelReservations() { return hotelReservations; }
    public List<FlightReservationItem> getFlightReservations() { return flightReservations; }

    public static class HotelReservationItem {
        @JsonProperty("Hotel_Code")
        private Long hotelCode;

        @JsonProperty("Check_In_Date")
        private String checkInDate;

        @JsonProperty("Check_In_Time")
        private String checkInTime;

        @JsonProperty("Check_Out_Date")
        private String checkOutDate;

        @JsonProperty("Check_Out_Time")
        private String checkOutTime;

        @JsonProperty("Rate")
        private BigDecimal rate;

        public Long getHotelCode() { return hotelCode; }
        public String getCheckInDate() { return checkInDate; }
        public String getCheckInTime() { return checkInTime; }
        public String getCheckOutDate() { return checkOutDate; }
        public String getCheckOutTime() { return checkOutTime; }
        public BigDecimal getRate() { return rate; }
    }

    public static class FlightReservationItem {
        @JsonProperty("Airline_Code")
        private String airlineCode;

        @JsonProperty("Flight_Number")
        private String flightNumber;

        @JsonProperty("Departure_Date")
        private String departureDate;

        @JsonProperty("Departure_Time")
        private String departureTime;

        @JsonProperty("Arrive_Date")
        private String arriveDate;

        @JsonProperty("Arrive_Time")
        private String arriveTime;

        @JsonProperty("Rate")
        private BigDecimal rate;

        @JsonProperty("Origin_Airport_Code")
        private String originAirportCode;

        @JsonProperty("Destination_Airport_Code")
        private String destinationAirportCode;

        public String getAirlineCode() { return airlineCode; }
        public String getFlightNumber() { return flightNumber; }
        public String getDepartureDate() { return departureDate; }
        public String getDepartureTime() { return departureTime; }
        public String getArriveDate() { return arriveDate; }
        public String getArriveTime() { return arriveTime; }
        public BigDecimal getRate() { return rate; }
        public String getOriginAirportCode() { return originAirportCode; }
        public String getDestinationAirportCode() { return destinationAirportCode; }
    }
}