package com.cmpe131.travel.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Hotel_Reservations")
public class HotelReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation_No")
    private Long reservationNo;

    @Column(name = "Booking_Id")
    private Long bookingId;

    @Column(name = "Hotel_Code")
    private String hotelCode;

    @Transient
    private String hotelName;

    @Column(name = "Check_In_Date")
    private String checkInDate;

    @Column(name = "Check_Out_Date")
    private String checkOutDate;

    @Column(name = "Rate")
    private BigDecimal hotelRate;

    public HotelReservation() {}

    public HotelReservation(Long bookingId, String hotelCode, String hotelName,
                             String checkInDate, String checkOutDate, BigDecimal hotelRate) {
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
