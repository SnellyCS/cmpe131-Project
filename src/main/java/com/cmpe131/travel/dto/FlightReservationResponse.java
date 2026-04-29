package com.cmpe131.travel.dto;
import java.math.BigDecimal;

public class FlightReservationResponse {

    private Long reservationNo;
    private Long bookingId;
    private String airlineCode;
    private String flightNumber;
    private String departureDate;
    private String departureTime;
    private String arriveDate;
    private String arriveTime;
    private BigDecimal rate;
    private String originAirportCode;
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