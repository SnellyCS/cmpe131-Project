package com.cmpe131.travel.dto;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightReservationResponse {

    @JsonProperty("Reservation_No")
    private Long reservationNo;

    @JsonProperty("Booking_Id")
    private Long bookingId;

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

    public FlightReservationResponse() {}

    public FlightReservationResponse(Long reservationNo, Long bookingId, String airlineCode, String flightNumber, String departureDate, String departureTime, String arriveDate, String arriveTime, BigDecimal rate, String originAirportCode, String destinationAirportCode) {
        this.reservationNo = reservationNo;
        this.bookingId = bookingId;
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.rate = rate;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }


    //Accessors
    public Long getReservationNo() {
        return reservationNo;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getAirlineCode() {
        return airlineCode;
    }
    
    public String getFlightNumber() { 
        return flightNumber; 
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

    public BigDecimal getRate() { 
        return rate; 
    }

    public String getOriginAirportCode() { 
        return originAirportCode; 
    }

    public String getDestinationAirportCode() { 
        return destinationAirportCode; 
    }


    //Setters
    public void setReservationNo(Long reservationNo) { 
        this.reservationNo = reservationNo; 
    }

    public void setBookingId(Long bookingId) { 
        this.bookingId = bookingId; 
    }

    public void setAirlineCode(String airlineCode) { 
        this.airlineCode = airlineCode; 
    }

    public void setFlightNumber(String flightNumber) { 
        this.flightNumber = flightNumber; 
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

    public void setRate(BigDecimal rate) { 
        this.rate = rate; 
    }

    public void setOriginAirportCode(String originAirportCode) { 
        this.originAirportCode = originAirportCode; 
    }

    public void setDestinationAirportCode(String destinationAirportCode) { 
        this.destinationAirportCode = destinationAirportCode; 
    }

}