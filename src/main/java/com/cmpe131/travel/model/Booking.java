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

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "Agent_Id")
    private Long agentId;

    @Column(name = "Start_Date")
    private String startDate;

    @Column(name = "End_Date")
    private String endDate;

    public Booking() {}

    public Long getBookingId() { return bookingId; }
    public Long getUserId() { return userId; }
    public Long getAgentId() { return agentId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }

    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
}
